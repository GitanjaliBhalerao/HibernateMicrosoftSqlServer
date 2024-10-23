package com.example.main;


import com.example.entity.Book;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UpdateBook {
    public static void updateBook(Long bookId, String newTitle, String newAuthor, Double newPrice) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            Book book = session.get(Book.class, bookId);
            if (book != null) {
                transaction = session.beginTransaction();
                book.setTitle(newTitle);
                book.setAuthor(newAuthor);
                book.setPrice(newPrice);
                session.update(book);
                transaction.commit();
            } else {
                System.out.println("Book not found!");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}