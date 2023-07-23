package com.dev.gam.mswebfluxr2dbc.business;

import com.dev.gam.mswebfluxr2dbc.model.dto.LibraryDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LibraryService {

  Flux<LibraryDto> findAll();
  Mono<Void> save(LibraryDto libraryDto);

}
