package com.example.spring6webapp.service.impl;

import com.example.spring6webapp.domain.Book;
import com.example.spring6webapp.repository.BookRepository;
import com.example.spring6webapp.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
