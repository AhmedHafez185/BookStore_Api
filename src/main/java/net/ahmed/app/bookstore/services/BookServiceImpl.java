/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.bookstore.services;

import java.util.List;
import net.ahmed.app.bookstore.models.Book;
import net.ahmed.app.bookstore.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ahmed Hafez
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepo bookRepo;

    @Transactional
    @Override
    public Book save(Book book) {
        return bookRepo.save(book);
    }

    @Transactional
    @Override
    public Book get(Long id) {
        return bookRepo.get(id);
    }

    @Transactional
    @Override
    public List<Book> getAll() {
        return bookRepo.getAll();
    }

    @Transactional
    @Override
    public Book update(Book book) {
        return bookRepo.update(book);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        bookRepo.delete(id);
    }

}
