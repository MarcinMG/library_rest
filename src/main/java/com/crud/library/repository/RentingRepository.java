package com.crud.library.repository;

import com.crud.library.domain.Renting;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RentingRepository extends CrudRepository<Renting, Long> {

    @Override
    List<Renting> findAll();
}
