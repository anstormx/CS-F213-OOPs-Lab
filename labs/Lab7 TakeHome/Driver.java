public class Driver
{
    public static void main(String[] args)
    {
        System.out.println("\033[32m\nHello! Welcome to First Take Home Lab.");
        System.out.println("This is a test driver for the classes you have to implement in this lab.");
        System.out.println("Implement each class and uncomment and check your marks.");
        System.out.println("Please complete it step by step, the marks will be calculated sequentially.\033[0m");
        int marks = 0;
        // ---------------------------------------------------------------------------------
        // -------------------------- Point2D Class -----------------------------------
        //  Uncomment the following after completing the Point2D class
        Point2D p = new Point2D(-1, -3);
        Point2D q = new Point2D(10, 30);
        if(p.getX() != -1 || q.getX() != 10)
        {
            System.out.println("getX is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
        }
        if(p.getY() != -3 || q.getY() != 30)
        {
            System.out.println("getY is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
        }
        p.move(-2, -5);
        if(p.getX() != -2 || p.getY() != -5)
        {
            System.out.println("move is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
        }
        System.out.println("Point2D is correct, Proceed to the Shape class.");
        marks++;
        // // //-------------------------------------------------------
        // // // --------------- Shape Class --------------------------
        // // Uncomment the following after completing the Shape class

        Shape shape1 = new Shape(-5, 10);
        if(shape1.getCentre().getX() != -5 || shape1.getCentre().getY() != 10)
        {
            System.out.println("getCentre() is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
        }
        if(shape1.getArea() != 0)
        {
            System.out.println("getArea is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
        }
        if(shape1.getPerimeter() != 0)
        {
            System.out.println("getPerimeter is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
        }
        shape1.move(5, 10);
        if(shape1.getCentre().getX() != 5 || shape1.getCentre().getY() != 10)
        {
            System.out.println("move is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
        }
        System.out.println("Shape is correct, Proceed to the Circle class.");
        marks++;

        // // //-------------------------------------------------------
        // // // --------------- Circle Class --------------------------
        // // Uncomment the following after completing the Circle class


        Circle circle1 = new Circle(p, 5);
        Circle circle2 = new Circle(25, 50, 10);
        if(circle1.getRadius() != 5 || circle2.getRadius() != 10)
        {
            System.out.println("getRadius is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
        }
        if(circle1.getArea() != 78.53981633974483 || circle2.getArea() != 314.1592653589793)
        {
            System.out.println("getArea is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
        }
        if(circle1.getPerimeter() != 31.41592653589793 || circle2.getPerimeter() != 62.83185307179586)
        {
            System.out.println("getPerimeter is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
        }
        if(circle1.withinCircle(new Point2D(-2, 0)) != true || circle1.withinCircle(new Point2D(-2, 1)) || circle1.withinCircle(new Point2D(-2, -5)) != true)
        {
            System.out.println("withinCircle is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
        }
        System.out.println("Circle is correct, Proceed to the Card class.");
        marks++;

        // // //-------------------------------------------------------
        // // // --------------- Card Class --------------------------
        // // Uncomment the following after completing the Card class


        int[] damage1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] damage2 = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        Card ob1 = new Card("ob1", 100, damage1, 50, 50, 50);
        Card ob2 = new Card("ob2", 200, damage2, 100, 100, 100);
        if(ob1.getName() != "ob1" || ob2.getName() != "ob2")
        {
            System.out.println("getName is Wrong");
            System.out.println("Partial marks: " + marks);

            return;
        }
        if(ob1.getHealth() != 100 || ob2.getHealth() != 200)
        {
            System.out.println("getHealth is Wrong");
            System.out.println("Partial marks: " + marks);

            return;
        }
        if(ob1.getLevel() != 0)
        {
            System.out.println("getLevel is Wrong");
            System.out.println("Partial marks: " + marks);

            return;
        }
        if(ob1.getRange().getCentre().getX() != 50 || ob2.getRange().getCentre().getY() != 100 || ob1.getRange().getRadius() != 50)
        {
            System.out.println("getRange is Wrong");
            System.out.println("Partial marks: " + marks);

            return;
        }
        ob1.move(-50, -50);
        if(ob1.getRange().getCentre().getX() != -50 || ob1.getRange().getCentre().getY() != -50 || ob1.getRange().getRadius() != 50)
        {
            System.out.println("move is Wrong");
            System.out.println("Partial marks: " + marks);

            return;
        }
        for(int i = 0; i < damage1.length; i++)
        {
            if(ob1.getLevel() != i)
            {
                System.out.println("incLevel is Wrong");
                System.out.println("Partial marks: " + marks);

                return;
            }
            ob1.incLevel();
        }
        for(int i = 0; i < 5; i++)
        {
            if(ob1.getLevel() != damage1.length - 1)
            {
                System.out.println("incLevel is Wrong");
                System.out.println("Partial marks: " + marks);

                return;
            }
            ob1.incLevel();
        }
        if(ob1.withinRange(ob2) || ob2.withinRange(ob1))
        {
            System.out.println("withinRange is Wrong");
            System.out.println("Partial marks: " + marks);

            return;
        }
        ob2.move(0, -50);
        if(!ob1.withinRange(ob2) || !ob2.withinRange(ob1))
        {
            System.out.println("withinRange is Wrong");
            System.out.println("Partial marks: " + marks);

            return;
        }
        if(ob1.isDead() || ob2.isDead())
        {
            System.out.println("isDead is Wrong");
            System.out.println("Partial marks: " + marks);

            return;
        }
        ob1 = new Card("ob1", 100, damage1, -50, -50, 50);
        for(int i = 0; i < damage1.length; i++)
        {
            if(ob1.getDamage() != damage1[i])
            {
                System.out.println("getDamage is Wrong");
                System.out.println("Partial marks: " + marks);

                return;
            }
            ob1.incLevel();
        }
        for(int i = 0; i < 10; i++)
        {
            if(ob1.getHealth() != 100 - i*10)
            {
                System.out.println("takeDamage is Wrong");
                System.out.println("Partial marks: " + marks);

                return;
            }
            ob1.takeDamage(10);
        }
        for(int i = 0; i < 10; i++)
        {
            if(ob1.getHealth() != 0)
            {
                System.out.println("takeDamage is Wrong");
                System.out.println("Partial marks: " + marks);

                return;
            }
            ob1.takeDamage(10);
        }
        System.out.println("Card is correct, Proceed to the HogRider class.");
        marks++;

        // // //-------------------------------------------------------
        // // // --------------- HogRider Class --------------------------
        // // Uncomment the following after completing the HogRider class

        HogRider HogRider1 = new HogRider("HogRider 1", 1000, damage1, 50, 50, 50);
        Card obb = new Card("obb", 100, damage1, 1000, 1000, 0);
        HogRider1.attack(obb);
        if(obb.getHealth() != 100)
        {
            System.out.println("attack is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
        }
        obb.move(25, 25);
        int[] levelHogRider1 = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2};
        for(int i = 0; i < 10; i++)
        {
            int init = obb.getHealth();
            //System.out.println(init);
            HogRider1.attack(obb);
            //System.out.println(obb.getHealth());
            if(HogRider1.getLevel() != levelHogRider1[i + 1])
            {
            System.out.println("attack is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
            }
            if(obb.getHealth() != init - damage1[levelHogRider1[i]])
            {
            System.out.println("attack is Wrong");
            System.out.println("Partial marks: " + marks);

            return;
            }
        }
        for(int i = 0; i < 20; i++)
        {
            if(HogRider1.getLevel() >= damage1.length)
            {
            System.out.println("incLevel is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
            }
            HogRider1.incLevel();
        }
        System.out.println("HogRider is correct, Proceed to the Prince class.");
        marks++;

        // // //-------------------------------------------------------
        // // // --------------- Prince Class --------------------------
        // // Uncomment the following after completing the Prince class

        Prince Prince1 = new Prince("Prince 1", 1000, damage1, 50, 50, 50);
        Card obP = new Card("obP", 100, damage1, 1000, 1000, 0);
        Prince1.attack(obP);
        if(obP.getHealth() != 100)
        {
            System.out.println("attack is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
        }
        obP.move(25, 25);
        int[] levelPrince1 = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5};
        for(int i = 0; i < 10; i++)
        {
            int init = obP.getHealth();
            Prince1.attack(obP);
            if(Prince1.getLevel() != levelPrince1[i + 1])
            {
                System.out.println("attack is Wrong");
                System.out.println("Partial marks: " + marks);
                return;
            }
            if(obP.getHealth() != init - damage1[levelPrince1[i]])
            {
                System.out.println("attack is Wrong");
                System.out.println("Partial marks: " + marks);

                return;
            }
        }
        for(int i = 0; i < 20; i++)
        {
            if(Prince1.getLevel() >= damage1.length)
            {
                System.out.println("incLevel is Wrong");
                System.out.println("Partial marks: " + marks);

                return;
            }
            Prince1.incLevel();
        }
        System.out.println("Prince is correct, Proceed to the DarkPrince class.");
        marks++;


        // // //-------------------------------------------------------
        // // // --------------- DarkPrince Class --------------------------
        // // Uncomment the following after completing the DarkPrince class


        DarkPrince DarkPrince1 = new DarkPrince("DarkPrince1", 1000, damage1, 0, 0, 50);
        Card obDP = new Card("obDP", 100, damage1, 1000, 1000, 0);
        DarkPrince1.attack(obDP);
        if(obDP.getHealth() != 100)
        {
            System.out.println("attack is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
        }
        for(int i = 0; i < 10; i++)
        {
            int init = obP.getHealth();
            DarkPrince1.attack(obP);
            if(DarkPrince1.getLevel() != levelPrince1[i + 1])
            {
                System.out.println("attack is Wrong");
                System.out.println("Partial marks: " + marks);
                return;
            }
            if(obP.getHealth() != init - 2*damage1[levelPrince1[i]])
            {
                System.out.println("attack is Wrong");
                System.out.println("Partial marks: " + marks);
                return;
            }
        }
        for(int i = 0; i < 20; i++)
        {
            if(DarkPrince1.getLevel() >= damage1.length)
            {
                System.out.println("incLevel is Wrong");
                System.out.println("Partial marks: " + marks);
                return;
            }
            DarkPrince1.incLevel();
        }
        System.out.println("DarkPrince is correct, Proceed to the Wizard class.");
        marks+=2;

        // // //-------------------------------------------------------
        // // // --------------- Wizard Class --------------------------
        // // Uncomment the following after completing the Wizard class

        Wizard Wizard1 = new Wizard("Wizard 1", 1000, damage1, 50, 50, 50);
        Card ob3 = new Card("ob3", 100, damage1, 1000, 1000, 0);
        Wizard1.attack(ob3);
        if(ob3.getHealth() != 100)
        {
            System.out.println("attack is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
        }
        ob3.move(25, 25);
        int[] levelWizard1 = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5};
        for(int i = 0; i < 10; i++)
        {
            int init = ob3.getHealth();
            Wizard1.attack(ob3);
            if(Wizard1.getLevel() != levelWizard1[i + 1])
            {
                System.out.println("attack is Wrong");
                System.out.println("Partial marks: " + marks);
                return;
            }
            if(ob3.getHealth() != init - damage1[levelWizard1[i]])
            {
                System.out.println("attack is Wrong");
                System.out.println("Partial marks: " + marks);

                return;
            }
        }
        for(int i = 0; i < 20; i++)
        {
            if(Wizard1.getLevel() >= damage1.length)
            {
                System.out.println("incLevel is Wrong");
                System.out.println("Partial marks: " + marks);

                return;
            }
            Wizard1.incLevel();
        }
        System.out.println("Wizard is correct, Proceed to the IceWizard class.");
        marks++;

        // // //-------------------------------------------------------
        // // // --------------- InceWizard Class --------------------------
        // // Uncomment the following after completing the IceWizard class


        IceWizard icewiz = new IceWizard("icewiz", 1000, damage1, 0, 0, 50);
        Card ob4 = new Card("ob4", 100, damage1, 1000, 1000, 0);
        icewiz.attack(ob4);
        if(ob4.getHealth() != 100)
        {
            System.out.println("attack is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
        }
        for(int i = 0; i < 10; i++)
        {
            int init = ob3.getHealth();
            icewiz.attack(ob3);
            if(icewiz.getLevel() != levelWizard1[i + 1])
            {
                System.out.println("attack is Wrong");
                System.out.println("Partial marks: " + marks);
                return;
            }
            if(ob3.getHealth() != init - 2*damage1[levelWizard1[i]])
            {
                System.out.println("attack is Wrong");
                System.out.println("Partial marks: " + marks);
                return;
            }
        }
        for(int i = 0; i < 20; i++)
        {
            if(icewiz.getLevel() >= damage1.length)
            {
                System.out.println("incLevel is Wrong");
                System.out.println("Partial marks: " + marks);
                return;
            }
            icewiz.incLevel();
        }
        System.out.println("IceWizard is correct, Proceed to the Fireball class.");
        marks++;

        // // //-------------------------------------------------------
        // // // --------------- Fireball Class --------------------------
        // // Uncomment the following after completing the Fireball class

        Fireball c1 = new Fireball("c1", 100, damage1, 50, 50, 50);
        Fireball c2 = new Fireball("c2", 100, damage1, 50, 50, 50);
        c1.attack(c2);
        if(c2.getHealth() != 100)
        {
            System.out.println("attack is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
        }
        Wizard1.move(100, 100);
        icewiz.move(100, 100);
        int icewizhel2 = icewiz.getHealth();
        c1.attack(icewiz);
        if(icewiz.getHealth() != icewizhel2)
        {
            System.out.println("attack is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
        }
        int ahel2 = Wizard1.getHealth();
        c1.attack(Wizard1);
        if(Wizard1.getHealth() != ahel2)
        {
            System.out.println("attack is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
        }
        Wizard1.move(25, 25);
        icewiz.move(26, 27);
        int[] levelc = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9};
        for(int i = 0; i < levelc.length - 1; i++)
        {
            int init = icewiz.getHealth();
            c1.attack(icewiz);
            if(c1.getLevel() != levelc[i + 1])
            {
            System.out.println("attack is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
            }
            if(icewiz.getHealth() != init - damage1[levelc[i]])
            {
            System.out.println("attack is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
            }
        }
        for(int i = 0; i < levelc.length - 1; i++)
        {
            int init = Wizard1.getHealth();
            c2.attack(Wizard1);
            if(c2.getLevel() != levelc[i + 1])
            {
            System.out.println("attack is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
            }
            if(Wizard1.getHealth() != init - damage1[levelc[i]])
            {
            System.out.println("attack is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
            }
        }
        System.out.println("Fireball is correct, Proceed to the WizardFireball class.");
        marks++;

        // // //-------------------------------------------------------
        // // // --------------- WizardFireball Class --------------------------
        // // Uncomment the following after completing the WizardFireball class

        WizardFireball wf1 = new WizardFireball("wf1", 100, damage1, 50, 50, 50, Wizard1);
        WizardFireball wf2 = new WizardFireball("wf2", 100, damage1, 50, 50, 50, icewiz);
        wf1.attack(wf2);
        if(wf2.getHealth() != 100)
        {
            System.out.println("attack is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
        }
        Wizard1.move(100, 100);
        icewiz.move(100, 100);
        int icewizhel3 = icewiz.getHealth();
        wf1.attack(icewiz);
        if(icewiz.getHealth() != icewizhel3)
        {
            System.out.println("attack is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
        }
        int ahel3 = Wizard1.getHealth();
        wf1.attack(Wizard1);
        if(Wizard1.getHealth() != ahel3)
        {
            System.out.println("attack is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
        }
        Wizard1.move(25, 25);
        icewiz.move(26, 27);
        int[] levelwf = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9};
        for(int i = 0; i < levelwf.length - 1; i++)
        {
            int init = icewiz.getHealth();
            wf1.attack(icewiz);
            if(wf1.getLevel() != levelwf[i + 1])
            {
            System.out.println("attack is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
            }
            if(icewiz.getHealth() != init - damage1[levelwf[i]])
            {
            System.out.println("attack is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
            }
        }
        for(int i = 0; i < levelwf.length - 1; i++)
        {
            int init = Wizard1.getHealth();
            wf2.attack(Wizard1);
            if(wf2.getLevel() != levelwf[i + 1])
            {
            System.out.println("attack is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
            }
            if(Wizard1.getHealth() != init - damage1[levelwf[i]])
            {
            System.out.println("attack is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
            }
        }
        System.out.println("WizardFireball is correct, Proceed to the Healer class.");
        marks+=2;

        // // //-------------------------------------------------------
        // // // --------------- Healer Class --------------------------
        // // Uncomment the following after completing the Healer class

        int[] damage3 = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10};
        Healer h = new Healer("h", 100, damage3, 0, 0, 50);
        Healer h2 = new Healer("h2", 100, damage3, 0, 0, 1000);
        if(h2.getHealth() != 100)
        {
            System.out.println("heal is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
        }
        Fireball Fireball = new Fireball("Fireball", 100, damage1, 0, 0, 50);
        h.heal(Fireball);
        if(Fireball.getHealth() != 100)
        {
            System.out.println("heal is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
        }
        int[] levelh = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9, 9, 9};
        for(int i = 0; i < levelh.length - 1; i++)
        {
            int init = icewiz.getHealth();
            h.heal(icewiz);
            if(h.getLevel() != levelh[i + 1])
            {
                System.out.println("heal is Wrong");
                System.out.println("Partial marks: " + marks);
                return;
            }
            if(icewiz.getHealth() != init - damage3[levelh[i]])
            {
                System.out.println("heal is Wrong");
                System.out.println("Partial marks: " + marks);
                return;
            }
        }
        for(int i = 0; i < levelh.length - 1; i++)
        {
            int init = Wizard1.getHealth();
            h2.heal(Wizard1);
            if(h2.getLevel() != levelh[i + 1])
            {
                System.out.println("heal is Wrong");
                System.out.println("Partial marks: " + marks);
                return;
            }
            if(Wizard1.getHealth() != init - damage3[levelh[i]])
            {
                System.out.println("heal is Wrong");
                System.out.println("Partial marks: " + marks);
                return;
            }
        }
        Wizard1.move(100, 100);
        icewiz.move(100, 100);
        int icewizhel = icewiz.getHealth();
        h.heal(icewiz);
        if(icewiz.getHealth() != icewizhel)
        {
            System.out.println("heal is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
        }
        int ahel = Wizard1.getHealth();
        h.heal(Wizard1);
        if(Wizard1.getHealth() != ahel)
        {
            System.out.println("heal is Wrong");
            System.out.println("Partial marks: " + marks);
            return;
        }
        System.out.println("Healer is correct. Congratulations Lab is over.\n\n");
        marks+=2;
        // ---------------------------------------------------------------------------------
        // -------------------------- THE END  -----------------------------------
        if(marks == 15) {
            System.out.println("\u001B[32mCongratulations on completing the lab\u001B[0m");
            System.out.println("\u001B[32mMarks: " + marks + "/15\u001B[0m");
        } else {
            System.out.println("\u001B[34mComplete the remaining classes, your current score is " + marks + "/15\u001B[0m");
        }
        System.out.println("\u001B[31mMake sure that you have not hardcoded any value as we will be evaluating on a different driver code.\u001B[0m");
    }
}