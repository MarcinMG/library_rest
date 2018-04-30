package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RentingDto {
    private Long rentId;
    private BookCopies bookCopies;
    private Reader reader;
    private Date rentDate;
    private Date returnDate;
}
