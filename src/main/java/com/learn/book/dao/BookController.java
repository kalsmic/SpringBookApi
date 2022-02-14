package com.learn.book.dao;

import java.util.Optional;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> findAllBooks(){
        return (List<Book>) bookRepository.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findUserById(@PathVariable(value="id") long id){
        Optional<Book> book = bookRepository.findById(id);

        if(book.isPresent()){
            return ResponseEntity.ok().body(book.get());
        } else {
            return ResponseEntity.notFound().build();
        }
        
    }
    

    @PostMapping
    public Book saveBook(@Validated @RequestBody Book book){
        return bookRepository.save(book);
        
    }
}
