package day6;

import java.io.Serializable;

// Represents a library book that can be serialized for persistent storage
public class Book implements Serializable {

    // Unique registration number for the book, auto-incremented
    int regno;
    // Title of the book
    String title;
    // Status indicating if the book is currently issued
    boolean isIssued;
    // Static counter for generating unique registration numbers
    static int count = 1;
    
    // Constructor to create a new book with given title
    public Book(String title) {
        this.regno = count++; // Auto-increment registration number
        this.title = title;
        this.isIssued = true; // New books are marked as issued by default
    }
    
    // Setter for book title
    public void setTitle(String title) {
        this.title = title; // Fixed: Corrected to use parameter 'title' instead of field
    }
    
    // Getter for book title
    public String getTitle() {
        return title;
    }
    
    // Setter for issued status
    public void setIsIssued(boolean isIssued) {
        this.isIssued = isIssued;
    }
    
    // Getter for issued status
    public boolean isIssued() {
        return isIssued;
    }
    
    // Getter for registration number
    public int getRegNo() {
        return regno;
    }
    
    // Returns string representation of the book for display
    @Override
    public String toString() {
        return "Book [regNo=" + regno + ", title=" + title + ", isIssued=" + isIssued + "]";
    }
    
    // Note: For proper HashSet functionality in Util.issueBook(), consider implementing
    // equals() and hashCode() to compare books by content (e.g., title or regno)
}
