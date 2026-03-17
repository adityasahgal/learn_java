abstract class Vehicle {

    abstract void start();

    void fuelType() {
        System.out.println("Petrol/Diesel");
    }
}

class Car extends Vehicle {

    void start() {
        System.out.println("Car starts with key");
    }
}

class Bike extends Vehicle {

    void start() {
        System.out.println("Bike starts with key");
    }
}

public class Abstraction {
    public static void main(String[] args) {

        Car c = new Car();
        c.start();
        c.fuelType();

        Bike b = new Bike();
        b.start();
        b.fuelType();
    }
}