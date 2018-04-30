package com.crud.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RentRequestDto {
    private Long readerId;
    private Long bookCopiesId;
}
