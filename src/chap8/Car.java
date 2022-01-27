package chap8;

abstract class Fuel {
    abstract void printFuelType();
}
class Petrol extends Fuel {
    public void printFuelType() {
        System.out.print("petrol");
    }
}
class Diesel extends Fuel {
    public void printFuelType() {
        System.out.print("diesel");
    }
}

abstract class Vehicle {

    public void fuel(Fuel fuel) {
        System.out.print("fuel Vehicle type - ");
        fuel.printFuelType();
    }

    abstract void serviceEngine();
}

public class Car extends Vehicle {

    @Override
    void serviceEngine() {
        System.out.println("Service Car engine");
    }

    public static void main(String[] args) {

        Car car = new Car();
        car.fuel(new Petrol());
        car.fuel(new Diesel());
    }
}
