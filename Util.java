package day6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Utility class for managing book issuance and serialization/deserialization of issued books
public class Util {

    // File name for storing serialized issued books data
    String file;
    // Set to store issued books (HashSet prevents duplicates based on object reference)
    Set<Book> issuedBooks;
    
    // Default constructor initializing file name and empty set for issued books
    public Util() {
        this.file = "books"; // Default file name for serialization
        issuedBooks = new HashSet<>(); // HashSet for unique books
    }
    
    // Issues a book if it's not already issued
    public void issueBook(Book b) {
        if (issuedBooks.contains(b)) {
            // Book already exists in issuedBooks set (based on object reference)
            System.out.println("Book already issued!");
        } else {
            // Add book to issuedBooks set and mark as issued
            issuedBooks.add(b);
            System.out.println("Book Issued!");
        }
    }
    
    // Serializes the issuedBooks set to a file
    public void Serialize() {
        try (Scanner sc = new Scanner(System.in); // Note: Scanner is unused in this method
             ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            
            // Write the issuedBooks set to the file
            out.writeObject(issuedBooks);
            System.out.println("Serialization done!!!");
            
        } catch (Exception e) {
            // Handle serialization exceptions (e.g., IOException)
            e.printStackTrace();
        }
    }
    
    // Deserializes issued books from file and restores them to issuedBooks set
    public void Deserialize() {
        try (Scanner sc = new Scanner(System.in); // Note: Scanner is unused in this method
             ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            
            // Read and cast the Set<Book> object from the file
            issuedBooks = (Set<Book>) in.readObject();
            System.out.println("Restored Products!!");
            
            // Print each restored book
            issuedBooks.forEach(b -> System.out.println(b));
            System.out.println("data restored...");
            
        } catch (Exception e) {
            // Handle deserialization exceptions (e.g., FileNotFoundException, ClassNotFoundException)
            // This may occur if the "books" file doesn't exist (e.g., first run)
            e.printStackTrace();
        }
    }
}
