public class Wizard extends Card   // An Wizard "is-a" Card
{
    protected int numAttacks;     // Number of attacks done by the Wizard
    public Wizard(String name, int initialHealth, int[] damage, int x, int y, int radius)   // Constructor
    {
        super(name, initialHealth, damage, x, y, radius);
        this.numAttacks = 0;
    }
    public Wizard(String name, int initialHealth, int[] damage, int radius, Point2D centre)   // Overloaded Constructor
    {
        super(name, initialHealth, damage, radius, centre);
        this.numAttacks = 0;
    }
    
    public void attack(Card obj)     // Attack another Card
    {
        if (withinRange(obj)) {
            obj.takeDamage(getDamage());
            numAttacks++;
        } else {
            System.out.println("Out of Range");
        }

        if (numAttacks == 2) {
            incLevel();
            numAttacks = 0;
        }
    }
}