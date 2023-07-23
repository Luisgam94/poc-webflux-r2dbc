package com.dev.gam.mswebfluxr2dbc.business.impl;

import com.dev.gam.mswebfluxr2dbc.business.AddressBuilder;
import com.dev.gam.mswebfluxr2dbc.business.AddressService;
import com.dev.gam.mswebfluxr2dbc.model.dto.AddressDto;
import com.dev.gam.mswebfluxr2dbc.model.entity.Address;
import com.dev.gam.mswebfluxr2dbc.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class AddressServiceImpl implements AddressService {

  @Autowired
  AddressRepository addressRepository;

  @Autowired AddressBuilder builder;

  @Override
  public Flux<AddressDto> findAll() {
    return addressRepository.findAll()
        .map(builder::toAddressDto)
        .doOnComplete(()->log.info("finish find all address"));
  }

  @Override
  public Mono<Void> save(AddressDto addressDto) {
    return addressRepository.save(Address.builder().location(addressDto.getLocation()).build())
        .then()
        .doOnSuccess((a)->log.info("finished save address"));
  }
}
