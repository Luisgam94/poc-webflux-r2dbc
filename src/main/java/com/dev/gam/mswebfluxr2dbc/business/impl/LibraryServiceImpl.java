package com.dev.gam.mswebfluxr2dbc.business.impl;

import com.dev.gam.mswebfluxr2dbc.business.AddressBuilder;
import com.dev.gam.mswebfluxr2dbc.business.LibraryBuilder;
import com.dev.gam.mswebfluxr2dbc.business.LibraryService;
import com.dev.gam.mswebfluxr2dbc.exceptions.CustomizedMessageException;
import com.dev.gam.mswebfluxr2dbc.model.dto.AddressDto;
import com.dev.gam.mswebfluxr2dbc.model.dto.LibraryDto;
import com.dev.gam.mswebfluxr2dbc.model.entity.Address;
import com.dev.gam.mswebfluxr2dbc.model.entity.Library;
import com.dev.gam.mswebfluxr2dbc.repository.AddressRepository;
import com.dev.gam.mswebfluxr2dbc.repository.LibraryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class LibraryServiceImpl implements LibraryService {

  @Autowired
  LibraryRepository repository;

  @Autowired
  AddressRepository addressRepository;

  @Autowired
  LibraryBuilder builder;

  @Override
  public Flux<LibraryDto> findAll() {
    return repository.findAll()
        .flatMap((library) -> addressRepository.findById(library.getAddressId())
            .map((address)-> builder.toLibraryDto(library,address)))
       .doOnComplete(()->log.info("Finished find All Libraries"));
  }

  @Override
  public Mono<Void> save(LibraryDto libraryDto) {
    return addressRepository.findById(libraryDto.getAddress().getId())
            .switchIfEmpty(Mono.error(new CustomizedMessageException("El Id no existe")))
            .flatMap((address) ->
                repository.findByAddressId(address.getId())
                    .hasElement()
                    .flatMap(hasElement -> {
                      if (hasElement) {
                        return Mono.error(new CustomizedMessageException("Se encontró un registro"));
                      } else {
                        return repository.save(Library.builder()
                                .name(libraryDto.getName())
                                .addressId(libraryDto.getAddress().getId())
                                .build())
                            .doOnSuccess(a -> log.info("Library guardada"));
                      }
                    })
            ).then();
  }
}
