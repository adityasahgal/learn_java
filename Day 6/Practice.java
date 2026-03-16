class Vehicle {

    String brand;

    Vehicle(String brand) {
        this.brand = brand;
    }

    void display() {
        System.out.println("Brand: " + brand);
    }
}

class Car extends Vehicle {

    int doors;

    Car(String brand, int doors) {
        super(brand);
        this.doors = doors;
    }

    void showCar() {
        System.out.println("Car Doors: " + doors);
    }
}

class Bike extends Vehicle {

    int mileage;

    Bike(String brand, int mileage) {
        super(brand);
        this.mileage = mileage;
    }

    void showBike() {
        System.out.println("Bike Mileage: " + mileage);
    }
}

class Truck extends Vehicle {
    int topspeed;

    Truck(String brand, int topspeed) {
        super(brand);
        this.topspeed = topspeed;
    }

    void showTruck() {
        System.out.println("Truck Top Speed: " + topspeed);
    }
}

public class Practice {
    public static void main(String[] args) {

        Car c = new Car("Toyota", 4);
        Bike b = new Bike("Yamaha", 45);
        Truck e = new Truck("Tata", 15);

        c.display();
        c.showCar();

        System.out.println("-----");

        b.display();
        b.showBike();

        System.out.println("-----");

        e.display();
        e.showTruck();

    }
}