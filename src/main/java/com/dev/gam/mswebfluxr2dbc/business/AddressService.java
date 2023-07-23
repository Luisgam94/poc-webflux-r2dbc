package com.dev.gam.mswebfluxr2dbc.business;

import com.dev.gam.mswebfluxr2dbc.model.dto.AddressDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AddressService {

  Flux<AddressDto> findAll();
  Mono<Void> save(AddressDto addressDto);

}
