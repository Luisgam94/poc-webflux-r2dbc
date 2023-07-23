package com.dev.gam.mswebfluxr2dbc.controller;

import com.dev.gam.mswebfluxr2dbc.business.LibraryService;
import com.dev.gam.mswebfluxr2dbc.model.dto.LibraryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/library")
public class LibraryController {

  @Autowired
  LibraryService libraryService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<ResponseEntity<Void>> saveLibrary(@Valid @RequestBody LibraryDto libraryDto) {
    return libraryService.save(libraryDto)
        .map((l) -> ResponseEntity.status(HttpStatus.CREATED).body(l));
  }

  @GetMapping//(produces = MediaType.APPLICATION_NDJSON_VALUE)
  public ResponseEntity<Flux<LibraryDto>> findAllLibraries() {
    return ResponseEntity.ok(libraryService.findAll());
  }


}
