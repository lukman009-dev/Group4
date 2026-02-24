5 class Author {
private String name; 
private String email; 
private char gender;
// Constructor
public Author(String name, String email, char gender) {
    this.name = name;  
    this.email = email; 
    this.gender = gender;
}
// Getters 
public String getName() {
    return name;
}
public String getEmail() {
    return email;
}
public char getGender() {
    return gender;
}
// Setters 
public void setEmail(String email) {
    this.email = email;
}
//toString 
public String toString() {
    return "Author[name=" + name + ", email=" + email + ", gender=" + gender + "]";
}
}

//Part B 
class Book {
private String name;
private Author author;	
// Composition 
private double price; 
private int qty;

// Constructor 
public Book(String name, Author author, double price) {
    this.name = name;
    this.author = author; 
    this.price = price; 
    this.qty = 0;
}
// Constructor 2
public Book(String name, Author author, double price, int qty) {
    this.name = name;   
    this.author = author;  
    this.price = price; 
    this.qty = qty;
}
// Getters 
public String getName() {
    return name;
}
public Author getAuthor() {
    return author;
}
public double getPrice() {
    return price;
}
public int getQty() {
    return qty;
}
// Setters 
public void setPrice(double price) {
    this.price = price;
}
public void setQty(int qty) {
    this.qty = qty;
}
// Delegation
public String getAuthorName() {
    return author.getName();
}
public String getAuthorEmail() {
    return author.getEmail();
}
public char getAuthorGender() { 
    return author.getGender();
}
//toString 
public String toString() {
    return "Book[name=" + name + ", " + author.toString() +
        ", price=" + price + ", qty=" + qty + "]";
}
}

//Part C
Author author1 = new Author("Ali Sultan", "ali.sultan@suza.ac.tz", 'm');
Author author2 = new Author("Mwanaisha Bakari", "mwanaisha.b@suza.ac.tz", 'f');
Author author3 = new Author("Hamad Khamis", "hamad.k@gmail.com", 'm');
System.out.println(author1);
System.out.println(author2);
System.out.println(author3);
Book book1 = new Book("Introduction to Java", author1, 35000, 50);
Book book2 = new Book("Data Structures in Java", author2, 42000, 30);
System.out.println(book1);
System.out.println(book2);
System.out.println("Book: " + book1.getName());
System.out.println("Author name: " + book1.getAuthorName());
System.out.println("Author email: " + book1.getAuthorEmail());
Author bookAuthor = book1.getAuthor();
System.out.println("Author object: " + bookAuthor);
Book book3 = new Book("Advanced Java Programming", author1, 55000, 20);
System.out.println("Book 1 author: " + book1.getAuthorName());
System.out.println("Book 3 author: " + book3.getAuthorName());
System.out.println("Same author? " + (book1.getAuthor() == book3.getAuthor()));
author1.setEmail("ali.sultan.new@suza.ac.tz");
System.out.println("\nAfter changing author1's email:");
System.out.println("Book 1 author email: " + book1.getAuthorEmail()); System.out.println("Book 3 author email: " + book3.getAuthorEmail());
Book book4 = new Book( "Python for Beginners",
new Author("Salma Haji", "salma.h@suza.ac.tz", 'f'),
28000,
100
);
System.out.println(book4);
System.out.println("Author: " + book4.getAuthorName());
Book[] inventory = {book1, book2, book3, book4};
System.out.println("SUZA Bookshop Inventory:");
System.out.println(String.format("%-30s %-25s %10s %5s",
"Title", "Author", "Price(TZS)", "Qty")); System.out.println("-".repeat(75));
double totalValue = 0; for (Book book : inventory) {
System.out.println(String.format("%-30s %-25s %,10.0f %5d", book.getName(), book.getAuthorName(), book.getPrice(), book.getQty()));
totalValue += book.getPrice() * book.getQty();
}
System.out.println("-".repeat(75));
System.out.println(String.format("Total inventory value: TZS %,.0f", totalValue));
