public class Shape {
    private String color; 
    private boolean filled;

    public Shape() {
        this.color = "red"; this.filled = true;
}
    public Shape(String color, boolean filled) {
        this.color = color; 
        this.filled = filled;
}
    public String getColor() {
        return color;
}
 
    public void stColor(String color) {
        this.color = color;
}
    public boolean isFilled() {
        return filled;
}
    public void setFilled(boolean filled) {
        this.filled = filled;
}
@Override 
public String toString() {
    return "Shape[color=" + color + ", filled=" + filled + "]";
}
}

// Circle Class

class Circle extends Shape {
    private double radius;

    public Circle() { 
        super(); 
        this.radius = 1.0;
}
    public Circle(double radius) {
        super(); 
        this.radius = radius;
}
    public Circle(double radius, String color, boolean filled) {
        super(color, filled); 
        this.radius = radius;
}
    public double getRadius() {
        return radius;
}
    public void setRadius(double radius) {
        this.radius = radius;
}
    public double getArea() {
        return Math.PI * radius * radius;
}
    public double getPerimeter() {
        return 2 * Math.PI * radius;
}
@Override 
    public String toString() {
        return "Circle[" + super.toString() + ", radius=" + radius + "]";
}
}

// PART C: Rectangle Class
public class Rectangle extends Shape {
    //attribute
    private double width; 
    private double length;

public Rectangle() {
 
    super(); 
    this.width = 1.0; 
    this.length = 1.0;
}
public Rectangle(double width, double length) {
    super(); 
    this.width = width; 
    this.length = length;
}
public Rectangle(double width, double length, String color, boolean filled) {
    super(color, filled); 
    this.width = width; 
    this.length = length;
}
public double getWidth() {
    return width;
}
public void setWidth(double width) {
    this.width = width;
}
public double getLength() { 
    return length;
}
public void setLength(double length) {
    this.length = length;
}
public double getArea() {
    return width * length;
}
public double getPerimeter() {
    return 2 * (width + length);
}
@Override 
public String toString() { 
    return "Rectangle[" + super.toString() +
", width=" + width +
", length=" + length + "]";
}
}

// Square Class

class Square extends Rectangle {
    public Square() {
        super();
}
public Square(double side) {
    super(side, side);
}
public Square(double side, String color, boolean filled) {
    super(side, side, color, filled);
}
public double getSide() {
    return getWidth();
}
public void setSide(double side) {
    super.setWidth(side); 
    super.setLength(side);
 
}
@Override
public void setWidth(double side) {
    super.setWidth(side); 
    super.setLength(side);
}
@Override
public void setLength(double side) {
    super.setWidth(side); 
    super.setLength(side);
}
@Override 
public String toString() {
    return "Square[" + super.toString() + "]";
}
}

//Test Driver 
public class Lab4_ShapeHierarchy {
    public static void main(String[] args) {
System.out.println("=============================================");
System.out.println(" Lab 4: Shape Hierarchy");
System.out.println("=============================================\n");
// Section 1
System.out.println("--- Section 1: Creating Objects ---");
Shape s1 = new Shape("yellow", false);
System.out.println(s1);
Circle c1 = new Circle(5.0, "blue", true);
System.out.println(c1);
System.out.println(" Area: " + c1.getArea());
System.out.println(" Perimeter: " + c1.getPerimeter());
Rectangle r1 = new Rectangle(4.0, 6.0, "green", true);
System.out.println(r1);
System.out.println(" Area: " + r1.getArea());
System.out.println(" Perimeter: " + r1.getPerimeter());
Square sq1 = new Square(5.0, "orange", false);
System.out.println(sq1);
System.out.println(" Area: " + sq1.getArea());
System.out.println(" Perimeter: " + sq1.getPerimeter());
// Section 2
System.out.println("\n--- Section 2: Square Invariant ---");
Square sq2 = new Square(3.0);
System.out.println("Initial: " + sq2);
System.out.println("Width: " + sq2.getWidth() +
", Length: " + sq2.getLength());
sq2.setWidth(7.0);
System.out.println("\nAfter setWidth(7.0):");
System.out.println("Width: " + sq2.getWidth() +
", Length: " + sq2.getLength());
sq2.setLength(9.0);
System.out.println("\nAfter setLength(9.0):");
System.out.println("Width: " + sq2.getWidth() +
", Length: " + sq2.getLength());
// Section 3
System.out.println("\n--- Section 3: Polymorphism ---");
Shape[] shapes = { new Circle(3.0, "red", true), new Rectangle(4.0, 5.0, "blue", false), new Square(6.0, "green", true), new Circle(7.0, "purple", true), new Rectangle(2.0, 8.0, "yellow", false)
};
double totalArea = 0;
for (Shape shape : shapes) { System.out.println(shape);
if (shape instanceof Circle) { Circle c = (Circle) shape; totalArea += c.getArea();
}
else if (shape instanceof Square) { Square sq = (Square) shape; totalArea += sq.getArea();
}
else if (shape instanceof Rectangle) {
Rectangle r = (Rectangle) shape; totalArea += r.getArea();
}
}
System.out.println("\nTotal area of all shapes: " + totalArea);
// Section 4
System.out.println("\n--- Section 4: Inheritance Chain ---");
Square sq3 = new Square(4.0, "cyan", true);
System.out.println("sq3 instanceof Square: " +
(sq3 instanceof Square));
System.out.println("sq3 instanceof Rectangle: " +
(sq3 instanceof Rectangle));
System.out.println("sq3 instanceof Shape: " +
(sq3 instanceof Shape));
System.out.println("\n=============================================");
System.out.println(" End of Lab 4");
System.out.println("=============================================");
}
}
