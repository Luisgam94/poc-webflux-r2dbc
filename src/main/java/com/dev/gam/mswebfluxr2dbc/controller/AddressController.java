package com.dev.gam.mswebfluxr2dbc.controller;

import com.dev.gam.mswebfluxr2dbc.business.AddressService;
import com.dev.gam.mswebfluxr2dbc.model.dto.AddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/address")
public class AddressController {

  @Autowired
  AddressService addressService;

  @GetMapping
  public Flux<AddressDto> findAllAddress() {
    return addressService.findAll();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Void> saveAddress(@Valid @RequestBody AddressDto addressDto) {
    return addressService.save(addressDto);
  }

}
