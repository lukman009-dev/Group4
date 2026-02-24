public class Circle {
    private double radius; 
    private String color;

//default constructors 
    public Circle() { 
    this.radius = 1.0; 
    this.color = "red";
}

// Constructor with radius 
public Circle(double radius) {
    this.radius = radius; 
    this.color = "red";
}
// perimeterized constructors
    public Circle(double radius, String color) {
        this.radius = radius; 
        this.color = color;
}
// Getters and their setters
    public double getRadius() {
        return radius;
}
    public void setRadius(double radius) {
        this.radius = radius;
}
    public String getColor() {
        return color;
}
    public void setColor(String color) {
        this.color = color;
}
    public double getArea() {
        return Math.PI * radius * radius;
}

@Override 
    public String toString() {
        return "Circle[radius=" + radius + ", color=" + color + "]";
}
}

//Cylinder Class
class Cylinder extends Circle {
private double height;
// Default constructor 
public Cylinder() { 
    super(); 
    this.height = 1.0;
}
// Perimeterized Constructor
public Cylinder(double radius) {
    super(radius); 
    this.height = 1.0;
}
// Constructor with radius and height 
    public Cylinder(double radius, double height) {
        super(radius);
        this.heigh = height;
}
// Constructor with radius, height and color 
    public Cylinder(double radius, double height, String color) {
        super(radius, color); 
        this.height = height;
}
// Getter and their Setter 
public double getHeight() {
    return height;
}
public void setHeight(double height) {
    this.height = height;
}
public double getVolume() {
    return getArea() * height;
}
@Override 
public String toString() {
    return "Cylinder[" + super.toString() + ", height=" + height + "]";
}
}

//Test Driver
public class Lab1_CircleCylinder {
public static void main(String[] args) {
System.out.println("=================================");
System.out.println(" Lab 1: Circle and Cylinder Hierarchy");
System.out.println("==================================\n");
// the section
System.out.println("--- Section 1: Basic Object Creation --");
Circle c1 = new Circle(5.0, "blue");
System.out.println("Circle: " + c1);
System.out.println("Area: " + c1.getArea());
Cylinder cy1 = new Cylinder(5.0, 10.0, "green");
System.out.println("\nCylinder: " + cy1);
Sy tem.ou .println("Base Area: " + cy1.getArea());
System.out.println("Volume: " + cy1.getVolume());
//  Upcasting
System.out.println("\n--- Section 2: Upcasting ---");
Circle c2 = new Cylinder(3.0, 7.0, "yellow");
System.out.println("c2 is a: " + c2.getClass().getSimpleName());
System.out.println("c2.toString(): " + c2);
System.out.println("c2.getArea(): " + c2.getArea()); System.out.println("c2.getRadius(): " + c2.getRadius());

// Downcasting
System.out.println("\n--- Section 3: Downcasting ---");
Circle c3 = new Cylinder(4.0, 8.0, "purple");
Cylinder cy2 = (Cylinder) c3;
System.out.println("After downcast: " + cy2);
System.out.println("Now we can call getVolume(): " + cy2.getVolume()); 

//  instanceof
System.out.println("\n--- Section 4: instanceof Operator ---");
Circle[] shapes = { new Circle(2.0, "red"), new Cylinder(3.0, 5.0, "blue"), new Circle(4.0, "green"), new Cylinder(1.0, 10.0, "orange")
};
for (Circle shape : shapes) { System.out.println(shape);
if (shape instanceof Cylinder) {
Cylinder temp = (Cylinder) shape;
System.out.println(" -> This is a Cylinder! Volume = " + temp.getVolume());
} 
else {
    System.out.println(" -> This is just a Circle. Area = " + shape.getArea());
}
}
Sy tem.ou .println("\n========================================");
System.out.println(" End of Lab 1");
System.out.println("========================================");
}
}
