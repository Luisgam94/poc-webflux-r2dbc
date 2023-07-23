package com.dev.gam.mswebfluxr2dbc.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Library {

  @Id
  private long id;
  private String name;

  @Column("address_id")
  private Long addressId;

}
