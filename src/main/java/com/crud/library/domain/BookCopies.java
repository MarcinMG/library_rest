package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "bookCopies")
public class BookCopies {

    @Id
    @GeneratedValue
    @Column(name = "copyId", unique = true)
    private Long copyId;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;

    @Column(name = "status" )
    private String status;
}
