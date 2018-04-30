package com.crud.library.controller;

import com.crud.library.domain.BookCopiesDto;
import com.crud.library.mapper.BookCopiesMapper;
import com.crud.library.service.BookCopiesSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("/v1/bookCopies")
@RestController
@CrossOrigin("*")
public class BookCopiesController {

    @Autowired
    private BookCopiesSerice bookCopiesSerice;
    @Autowired
    private BookCopiesMapper bookCopiesMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getBooksCopies")
    public List<BookCopiesDto> getBookCopies() {
        return bookCopiesMapper.mapToBookCopiesDtoList(bookCopiesSerice.getAllBookCopies());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBookCopy")
    public BookCopiesDto getBookCopy(@RequestParam("copyId") Long copyId) throws BookCopiesNotFoundException {
        return bookCopiesMapper.mapToBookCopiesDto(bookCopiesSerice.getBookCopiesById(copyId));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBookCopy", consumes = APPLICATION_JSON_VALUE)
    public void createBookCopy(@RequestBody BookCopiesDto bookCopiesDto) {
        bookCopiesSerice.saveBookCopies(bookCopiesMapper.mapToBookCopies(bookCopiesDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBookCopy")
    public void deleteBookCopy(@RequestParam ("copyId") Long copyId) throws BookCopiesNotFoundException {
        bookCopiesSerice.deleteBookCopies(copyId);
    }
}
