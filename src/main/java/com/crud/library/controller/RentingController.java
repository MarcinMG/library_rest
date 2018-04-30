package com.crud.library.controller;


import com.crud.library.domain.RentRequestDto;
import com.crud.library.domain.RentingDto;
import com.crud.library.mapper.RentingMapper;
import com.crud.library.service.RentingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("/v1/renting")
@RestController
@CrossOrigin("*")
public class RentingController {

    @Autowired
    private RentingMapper rentingMapper;
    @Autowired
    private RentingService rentingService;

    @RequestMapping(method = RequestMethod.POST,value = "createRenting",consumes = APPLICATION_JSON_VALUE)
    public RentingDto createRenting(@RequestBody RentRequestDto rentRequestDto){
        return rentingMapper.mapToRentingDto(rentingService.rentBookCopiesByUser(rentRequestDto.getBookCopiesId(),
                rentRequestDto.getReaderId()));
    }
}
