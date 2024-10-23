package com.example.main;


import com.example.entity.Book;
import com.example.util.HibernateUtil;
import org.hibernate.Session;

public class ReadBook {
    public static void readBook(Long bookId) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Book book = session.get(Book.class, bookId);
            if (book != null) {
                System.out.println("Book details: " + book.getTitle() + ", " + book.getAuthor() + ", " + book.getPrice());
            } else {
                System.out.println("Book not found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
