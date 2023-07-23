package com.dev.gam.mswebfluxr2dbc.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

  private long id;
  private String location;

}
