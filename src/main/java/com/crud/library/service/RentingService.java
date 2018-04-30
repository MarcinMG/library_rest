package com.crud.library.service;

import com.crud.library.domain.BookCopies;
import com.crud.library.domain.Reader;
import com.crud.library.domain.Renting;
import com.crud.library.repository.RentingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RentingService {

    @Autowired
    private RentingRepository rentingRepository;

    @Autowired
    private BookCopiesSerice bookCopiesSerice;

    @Autowired
    private ReaderService readerService;

    public Renting rentBookCopiesByUser (final Long bookCopiesId, final Long readerId) {

        BookCopies bookCopies = bookCopiesSerice.getBookCopiesById(bookCopiesId);
        Reader reader = readerService.getReaderById(readerId);
        Date date = new Date();

        Renting renting = new Renting(bookCopies, reader, date);
        return rentingRepository.save(renting);
    }
}
