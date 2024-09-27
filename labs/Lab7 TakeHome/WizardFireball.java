public class WizardFireball extends Fireball    // A Fireball with an Wizard, both can attack separately.
// If the Fireball dies, the Wizard also dies
{
    private Wizard Wizard;  // An WizardFireball "has-a" Wizard

    public WizardFireball(String name, int initialHealth, int[] damage, int x, int y, int radius, Wizard Wizard)   // Constructor
    {
        super(name, initialHealth, damage, x, y, radius);
        this.Wizard = Wizard;
    }
    public WizardFireball(String name, int initialHealth, int[] damage, int radius, Point2D centre, Wizard Wizard)   // Overloaded Constructor
    {
        super(name, initialHealth, damage, radius, centre);
        this.Wizard = Wizard;
    }

    public boolean isWizardDead()   // The Wizard dies if the Fireball dies
    {
        return (Wizard.getHealth() == 0 || super.getHealth() == 0);
    }
    public void WizardAttack(Card obj)     // The Wizard attacks another Card
    {
        if (obj instanceof Fireball) {
            System.out.println("Attack Failed");
            return;
        } else if (withinRange(obj)) {
            obj.takeDamage(getDamage());
            super.numAttacks++;
        } else {
            System.out.println("Out of Range");
        }

        if (super.numAttacks == 4) {
            super.incLevel();
            super.numAttacks = 0;
        }
        
    }
}
