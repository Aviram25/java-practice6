package day6;

// Test class to demonstrate book issuance and serialization/deserialization functionality
public class Tester {

    // Main method to test the library management system
    public static void main(String[] args) {
        // Create a Util instance to manage book issuance and serialization
        Util util = new Util();
        
        // Attempt to deserialize existing data (may fail if "books" file doesn't exist)
        // Note: Consider commenting this out for the first run to avoid FileNotFoundException
        util.Deserialize();
        
        // Create sample books with different titles
        Book b1 = new Book("Java Prog");      // Book 1
        Book b2 = new Book("Data Analytics"); // Book 2
        Book b3 = new Book("Java Prog");      // Book 3 (same title as b1)
        
        // Test book issuance:
        // b1: Successfully issued (first "Java Prog" book)
        util.issueBook(b1);
        // b2: Successfully issued (unique title)
        util.issueBook(b2);
        // b1: Already issued (same object reference, rejected by HashSet)
        util.issueBook(b1); // Tests issuing the same book object again
        
        // Serialize the issued books to file for persistence
        util.Serialize();
    }
}
