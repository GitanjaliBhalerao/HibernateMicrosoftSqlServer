package com.example.main;

import com.example.entity.Book;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CreateBook {
    public static void createBook() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Book book = new Book();
            book.setTitle("Effective Java");
            book.setAuthor("Joshua Bloch");
            book.setPrice(45.0);
            session.save(book);
            transaction.commit();
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