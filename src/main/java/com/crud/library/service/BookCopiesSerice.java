package com.crud.library.service;


import com.crud.library.domain.BookCopies;
import com.crud.library.repository.BookCopiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCopiesSerice {

    @Autowired
    private BookCopiesRepository bookCopiesRepository;

    public List<BookCopies> getAllBookCopies() {
        return bookCopiesRepository.findAll();
    }

    public BookCopies getBookCopiesById(final Long id) {
        return bookCopiesRepository.findById(id).orElse(null);
    }

    public BookCopies saveBookCopies(BookCopies bookCopies) {
        return bookCopiesRepository.save(bookCopies);
    }

    public void deleteBookCopies(Long id) {
        bookCopiesRepository.deleteById(id);
    }

}
