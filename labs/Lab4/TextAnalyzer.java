public class TextAnalyzer {
    private String paragraph;
    private String[] words;
    private int[] wordFrequency;
    private String[] palindromicWords;
    private String longestWord;

    public TextAnalyzer(String paragraph) {
        this.paragraph = paragraph;
    }

    public void populateWords() {
        String[] wordarr = paragraph.split(" ");
        int count = 0;
        String[] tempwords = new String[wordarr.length];

        for (int i = 0; i < wordarr.length; i++) {
            boolean val = true;
            for (int j = 0; j < count; j++) {
                if (wordarr[i].equals(tempwords[j])) {
                    val = false;
                    break;
                }
            }
            if (val) {
                tempwords[count] = wordarr[i];
                count++;
            }
        }

        String[] unique = new String[count];
        for (int i = 0; i < count; i++) {
            unique[i] = tempwords[i];
        }
        words = unique;
    }

    public void populateWordFrequency() {
        wordFrequency = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int count = 0;
            for (int j = 0; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    count++;
                }
            }
            wordFrequency[i] = count;
        }
    }

    private boolean isPalindrome(String word) {
        int start = 0;
        int end = word.length() - 1;
        while (start < end) {
            if (word.charAt(end) != word.charAt(start)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public void populatePalindromicWords() {
        int count = 0;
        String[] tempwords = new String[words.length];
        for (String word : words) {
            if (isPalindrome(word)) {
                tempwords[count] = word;
                count++;
            }
        }
        String[] palindromicwords = new String[count];
        for (int i = 0; i < count; i++) {
            palindromicwords[i] = tempwords[i];
        }
        palindromicWords = palindromicwords;
    }

    public void populateLongestWord() {
        for (String word : words) {
            if (longestWord == null || longestWord.length() < word.length()) {
                longestWord = word;
            }
        }
    }

    public void displayResults() {
        if (longestWord == null)
            return;
        System.out.println("Count of unique words: " + words.length);
        System.out.println("Count of unique palindromes: " + palindromicWords.length);
        System.out.println("Longest word: " + longestWord);
    }

    public String getParagraph() {
        return paragraph;
    }

    public String[] getWords() {
        return words;
    }

    public int[] getWordFrequency() {
        return wordFrequency;
    }

    public String[] getPalindromicWords() {
        return palindromicWords;
    }

    public String getLongestWord() {
        return longestWord;
    }

    // DO NOT MODIFY THE CODE BELOW
    public void solve() {
        populateWords();
        populateWordFrequency();
        populatePalindromicWords();
        populateLongestWord();
        displayResults();
    }
}