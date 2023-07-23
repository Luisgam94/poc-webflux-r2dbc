package com.dev.gam.mswebfluxr2dbc.repository;

import com.dev.gam.mswebfluxr2dbc.model.entity.Library;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface LibraryRepository extends ReactiveCrudRepository<Library, Long> {

  Mono<Library> findByAddressId(Long Id);

}
