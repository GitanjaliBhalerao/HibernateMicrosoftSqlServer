package com.example.main;


public class MainApp {
    public static void main(String[] args) {
        // Create a new book
        CreateBook.createBook();
        System.out.println("Book created!");

        // Read the created book




        ReadBook.readBook(1L);

        // Update the created book
        UpdateBook.updateBook(1L, "Effective Java 3rd Edition", "Joshua Bloch", 50.0);
        System.out.println("Book updated!");

        // Read the updated book
        ReadBook.readBook(1L);

        // Delete the book
        DeleteBook.deleteBook(1L);
        System.out.println("Book deleted!");

        // Try to read the deleted book
        ReadBook.readBook(1L);
    }
}
