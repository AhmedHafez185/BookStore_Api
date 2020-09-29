/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ahmed.app.bookstore.config.controllers;


import java.util.List;
import net.ahmed.app.bookstore.models.Book;
import net.ahmed.app.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ahmed Hafez
 */
@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/books")
    public ResponseEntity<List<Book>> listAll() {
        List<Book> books = bookService.getAll();
        return ResponseEntity.ok().body(books);
    }
    @PostMapping("/addBook")
    public ResponseEntity<?> save(@RequestBody Book book){
        bookService.save(book);
        return ResponseEntity.ok().body("Book Created with id : "+book.getId());
    }
    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(bookService.get(id));
    }
    @PutMapping("/book/edit/")
    public ResponseEntity<?>  updateBook(@RequestBody Book book) {
        bookService.update(book);
        return ResponseEntity.ok().body("Book Updated with id : "+book.getId());
    }
     @DeleteMapping("/book/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
        bookService.delete(id);
        return ResponseEntity.ok().body("Book Deleted!!");
    }

}
