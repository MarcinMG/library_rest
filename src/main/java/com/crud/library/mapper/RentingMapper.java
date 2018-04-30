package com.crud.library.mapper;

import com.crud.library.domain.Renting;
import com.crud.library.domain.RentingDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RentingMapper {

    public Renting mapToRenting(final RentingDto rentingDto){
        return new Renting(
                rentingDto.getRentId(),
                rentingDto.getReader(),
                rentingDto.getBookCopies(),
                rentingDto.getRentDate(),
                rentingDto.getReturnDate());

    }

    public RentingDto mapToRentingDto(final Renting renting){
        return new RentingDto(
                renting.getRentId(),
                renting.getBookCopies(),
                renting.getReader(),
                renting.getRentDate(),
                renting.getReturnDate());
    }

    public List<RentingDto> mapToRentingDtoList(final List<Renting> rentingList){
        return rentingList.stream()
                .map(r -> new RentingDto(r.getRentId(), r.getBookCopies(), r.getReader(), r.getRentDate(), r.getReturnDate()))
                .collect(Collectors.toList());
    }
}
