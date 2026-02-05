/**
 * Exercise12_inheritence
 * Lukman khamis mussa 24BIA009
 */


class Vehicle {

    protected String brand;
    protected String model;
    protected int year;
    protected double price;

    // constructor that initializes all attributes
    public Vehicle(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    // Methods
    public void displayInfo() {
        System.out.println("====All Vehicle Info====");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Price: TZS " + price);
    }

    public void startEngine() {
        System.out.println(brand + " " + model + " engine started");
    }

    public void stopEngine() {
        System.out.println(brand + " " + model + " engine stopped");
    }
}


// Create class car extends vehicle

class Car extends Vehicle {

    private int numDoors;
    private String fuelType;

    public Car(String brand, String model, int year, double price, int numDoors, String fuelType) {
        super(brand, model, year, price);
        this.numDoors = numDoors;
        this.fuelType = fuelType;
    }

    // overriding method
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Doors: " + numDoors);
        System.out.println("Fuel: " + fuelType);
    }

    public void honk() {
        System.out.println(brand + " " + model + " says: Beep! Beep!");
    }

    public void openTrunk() {
        System.out.println("Trunk opening trunk of " + brand + " " + model);
    }
}


// Create a class "Motorcycle" that extends Vehicle

class Motorcycle extends Vehicle {

    private int engineCC;
    private boolean hasHelmetStorage;

    public Motorcycle(String brand, String model, int year, double price, int engineCC, boolean hasHelmetStorage) {
        super(brand, model, year, price);
        this.engineCC = engineCC;
        this.hasHelmetStorage = hasHelmetStorage;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Engine CC: " + engineCC);
        if (hasHelmetStorage == true) {
            System.out.println("Helmet Storage: Yes");
        } else {
            System.out.println("Helmet Storage: No");
        }
    }

    public void wheelie() {
        System.out.println(brand + " " + model + "is doing a wheelie");
    }

    public void kickStart() {
        System.out.println("Kick start " + brand + " " + model);
    }
}

// Create a class "ElectricCar" that extends Car

class ElectricCar extends Car {

    private double batteryCapacity;
    private int range;

    public ElectricCar(String brand, String model, int year, double price,
                       int numDoors, String fuelType, double batteryCapacity, int range) {
        super(brand, model, year, price, numDoors, fuelType);
        this.batteryCapacity = batteryCapacity;
        this.range = range;
    }

    // override startEngine
    public void startEngine() {
        System.out.println(brand + " " + model + " electric motor activated silently");
    }

    public void charge() {
        System.out.println("Charging " + brand + " " + model + "...battery " + batteryCapacity + " kWh");
    }

    public void displayBatteryStatus() {
        System.out.println("Battery: " + batteryCapacity + " kWh");
        System.out.println("Range: " + range + " km");
    }
}

// ===============================
// Main Class
// ===============================
public class Exercise12_Inheritance {

    public static void main(String[] args) {

        System.out.println("=== VEHICLE HIERARCHY TEST ===\n");

        Car car = new Car("Toyota", "Corolla", 2023, 45000000, 4, "Petrol");
        Motorcycle bike = new Motorcycle("Honda", "CBR500R", 2022, 15000000, 500, false);
        ElectricCar ecar = new ElectricCar("Tesla", "Model 3", 2024,
                85000000, 4, "Electric", 75.0, 450);

        System.out.println("---Testing Car----");
        car.displayInfo();
        car.startEngine();
        car.honk();
        car.openTrunk();
        car.stopEngine();

        System.out.println("\n---Testing Motorcycle----");
        bike.displayInfo();
        bike.startEngine();
        bike.wheelie();
        bike.kickStart();
        bike.stopEngine();

        System.out.println("\n----Testing Electric Car-----");
        ecar.displayInfo();
        ecar.startEngine();
        ecar.charge();
        ecar.displayBatteryStatus();
        ecar.honk();
        ecar.stopEngine();

        // polymorphism
        System.out.println("\nPolymorphism Example");
        Vehicle[] list = {car, bike, ecar};

        for (Vehicle v : list) {
            v.displayInfo();
            v.startEngine();
            System.out.println("\n=== END OF TEST ===");
        }
    }
}
