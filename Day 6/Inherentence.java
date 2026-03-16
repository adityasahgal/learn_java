class Vehicle {

    String brand = "Generic Brand";

    void start() {
        System.out.println("Vehicle is starting...");
    }
}

class Car extends Vehicle {

    void showCar() {
        System.out.println("This is a Car");
    }
}

class Bike extends Vehicle {

    void showBike() {
        System.out.println("This is a Bike");
    }
}

public class Inherentence {
    public static void main(String[] args) {

        Car c = new Car();
        c.start();
        c.showCar();

        System.out.println("Brand: " + c.brand);

        Bike b = new Bike();
        b.start();
        b.showBike();
    }
}