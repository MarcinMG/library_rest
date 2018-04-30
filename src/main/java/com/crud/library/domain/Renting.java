package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "renting")
public class Renting {

    @Id
    @GeneratedValue
    @Column(name = "rentId", unique = true)
    private Long rentId;

    @ManyToOne
    @JoinColumn(name = "readerId")
    private Reader reader;

    @ManyToOne
    @JoinColumn(name = "bookCopiesId")
    private BookCopies bookCopies;

    @Column(name = "rentDate")
    private Date rentDate;

    @Column(name = "returnDate")
    private Date returnDate;

    public Renting(BookCopies bookCopies, Reader reader, Date rentDate) {
        this.bookCopies = bookCopies;
        this.reader = reader;
        this.rentDate = rentDate;
    }
}
