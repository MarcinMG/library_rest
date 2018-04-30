package com.crud.library.mapper;

import com.crud.library.domain.Book;
import com.crud.library.domain.BookCopies;
import com.crud.library.domain.BookCopiesDto;
import com.crud.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookCopiesMapper {

    @Autowired
    private BookService bookService;
    public BookCopies mapToBookCopies(final BookCopiesDto bookCopiesDto) {
        Book book = bookService.getBookById(bookCopiesDto.getBookId());
        return new BookCopies(
                bookCopiesDto.getCopyId(),
                book,
                bookCopiesDto.getStatus());
    }

    public BookCopiesDto mapToBookCopiesDto(final BookCopies bookCopies) {

        return new BookCopiesDto(
                bookCopies.getCopyId(),
                bookCopies.getBook().getTitleId(),
                bookCopies.getStatus());
    }

    public List<BookCopiesDto> mapToBookCopiesDtoList(final List<BookCopies> bookList) {
        return bookList.stream()
                .map(b -> new BookCopiesDto(b.getCopyId(), b.getBook().getTitleId(), b.getStatus()))
                .collect(Collectors.toList());
    }

}
