public class Fireball extends Card {
    protected int numAttacks; // Number of attacks done by the Fireball

    public Fireball(String name, int initialHealth, int[] damage, int x, int y, int radius) // Constructor
    {
        super(name, initialHealth, damage, x, y, radius);
        this.numAttacks = 0;
    }

    public Fireball(String name, int initialHealth, int[] damage, int radius, Point2D centre) // Overloaded Constructor
    {
        super(name, initialHealth, damage, radius, centre);
        this.numAttacks = 0;
    }

    public void attack(Card obj) // Attack another Card, should not attack other Fireballs.
    {
        if ( obj instanceof Fireball ) {
            System.out.println("Attack Failed");
            return;
        } else if (withinRange(obj)) {
            obj.takeDamage(getDamage());
            numAttacks++;
        } else {
            System.out.println("Out of Range");
        }   

        if (numAttacks == 4) {
            incLevel();
            numAttacks = 0;
        }
    }
}
