/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.bookstore.repos;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import net.ahmed.app.bookstore.models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ahmed Hafez
 */
@Repository
public class BookRepoImpl implements BookRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Book save(Book book) {
        getCurrentSession().persist(book);
        return book;
    }

    @Override
    public Book get(Long id) {
        return getCurrentSession().get(Book.class, id);
    }

    @Override
    public List<Book> getAll() {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Book> entityCriteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> from = entityCriteriaQuery.from(Book.class);
        entityCriteriaQuery.select(from);
        Query<Book> cityQuery = getCurrentSession().createQuery(entityCriteriaQuery);
        List<Book> entityList = cityQuery.getResultList();
        return entityList;
    }

    @Override
    public Book update(Book book) {
        getCurrentSession().merge(book);
        return book;
    }

    @Override
    public void delete(Long id) {
        Book book = getCurrentSession().load(Book.class, id);
        getCurrentSession().delete(book);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
