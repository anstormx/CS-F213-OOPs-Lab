public class Healer extends Card // For a healer, the damage array will have negative values
{
    private int numHeals; // Number of heals done by the healer

    public Healer(String name, int initialHealth, int[] damage, int x, int y, int radius) // Constructor
    {
        super(name, initialHealth, damage, x, y, radius);
        this.numHeals = 0;
    }

    public Healer(String name, int initialHealth, int[] damage, int radius, Point2D centre) // Overloaded Constructor
    {
        super(name, initialHealth, damage, radius, centre);
        this.numHeals = 0;
    }

    public void heal(Card obj) // A healer should heal only an Wizard(Keep in mind that an IceWizard is also an
                               // Wizard)
    {
        if (!(obj instanceof Wizard)) {
            System.out.println("Heal Failed");
            return;
        } else if (withinRange(obj)) {
            obj.takeDamage(getDamage());
            numHeals++;
        } else {
            System.out.println("Out of Range");
        }

        if (numHeals == 3) {
            incLevel();
            numHeals = 0;
        }
    }
}
