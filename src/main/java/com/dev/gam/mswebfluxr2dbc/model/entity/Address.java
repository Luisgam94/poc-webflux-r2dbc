package com.dev.gam.mswebfluxr2dbc.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

  @Id
  private long id;
  private String location;

}
