public class Practice {
    public int[] getUniqueNumbers(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return new int[0]; // Return an empty array if the input string is null or empty
        }
    
        // Split the input string into an array of number strings
        String[] numberStrings = numbers.split(",");
        
        // Temporary array to store unique numbers
        int[] tempUniqueNumbers = new int[numberStrings.length];
        int uniqueCount = 0; // Counter for the unique numbers
    
        // Iterate through the number strings
        for (String numberString : numberStrings) {
            int number = Integer.parseInt(numberString.trim()); // Convert string to integer
            boolean isUnique = true;
            
            // Check if the number is already in the unique numbers array
            for (int i = 0; i < uniqueCount; i++) {
                if (tempUniqueNumbers[i] == number) {
                    isUnique = false;
                    break;
                }
            }
    
            // If the number is unique, add it to the unique numbers array
            if (isUnique) {
                tempUniqueNumbers[uniqueCount] = number;
                uniqueCount++;
            }
        }
    
        // Create the final array with the exact number of unique numbers
        int[] uniqueNumbersArray = new int[uniqueCount];
        System.arraycopy(tempUniqueNumbers, 0, uniqueNumbersArray, 0, uniqueCount);
    
        return uniqueNumbersArray;
    }

    public boolean isPalindrome(String word){
        int i = 0;
        int j = word.length() - 1;
        
        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false; // Return false if the characters at positions i and j are not equal
            }
            i++;
            j--;
        }
        
        return true; // Return true if the word is a palindrome
    }

    public static void main(String[] args) {
        Practice practice = new Practice();
        int[] uniqueNumbers = practice.getUniqueNumbers("1, 2, 3, 4, 5, 1, 2, 3, 4, 5");
        for (int number : uniqueNumbers) {
            System.out.println(number);
        }
        System.out.println("Length: " + uniqueNumbers.length); // Should be 5 for the given sample
        String notPalin = "hello";
        String palin = "racecar";
        System.out.println(notPalin + " is a palindrome: " + practice.isPalindrome(notPalin));
        System.out.println(palin + " is a palindrome: " + practice.isPalindrome(palin));
    }
}
