package com.crud.library.repository;

import com.crud.library.domain.BookCopies;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookCopiesRepository extends CrudRepository<BookCopies, Long> {

    @Override
    List<BookCopies> findAll();

    @Override
    Optional<BookCopies> findById(Long id);

}
