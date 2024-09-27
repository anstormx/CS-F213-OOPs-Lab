public class Car{

    // DEFINE THE FIELDS HERE
    int horsepower = 100;
    int fuel = 0;
    double mileage = 0;    

    // DEFINE THE THREE CONSTUCTORS
    public Car(int horsepower, int fuel, double mileage){
        this.horsepower = horsepower;
        this.fuel = fuel;
        this.mileage = mileage;
    }

    public Car(int horsepower, int fuel){
        this.horsepower = horsepower;
        this.fuel = fuel;
    }

    public Car(Car c){
        this.horsepower = c.horsepower;
        this.fuel = c.fuel;
        this.mileage = c.mileage;
    }

    // DEFINE THE setMileage() and showDetails() method
    public void setMileage(){
        mileage += horsepower * fuel;
        fuel = 0;
    }
    
    public void showDetails(){
        System.out.println(horsepower + " "+fuel+ " "+mileage);
    }

    public void solveCar(){
        setMileage();
        showDetails();
    }
}