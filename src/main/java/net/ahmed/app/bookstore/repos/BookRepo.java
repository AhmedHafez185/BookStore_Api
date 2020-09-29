/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.bookstore.repos;

import java.util.List;
import net.ahmed.app.bookstore.models.Book;

/**
 *
 * @author Ahmed Hafez
 */
public interface BookRepo {

    public Book save(Book book);

    public Book get(Long id);

    public List<Book> getAll();

    public Book update(Book book);

    public void delete(Long id);
}
