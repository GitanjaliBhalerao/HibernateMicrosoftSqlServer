package com.example.main;

import com.example.entity.Book;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeleteBook {
    public static void deleteBook(Long bookId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            Book book = session.get(Book.class, bookId);
            if (book != null) {
                transaction = session.beginTransaction();
                session.delete(book);
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
