package com.dev.gam.mswebfluxr2dbc.model.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LibraryDto {

  private long id;

  @NotBlank
  private String name;

  @NotNull
  @Valid
  private AddressDto address;

  //private List<BookDto> books;

}
