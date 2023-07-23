package com.dev.gam.mswebfluxr2dbc.business;

import com.dev.gam.mswebfluxr2dbc.model.dto.AddressDto;
import com.dev.gam.mswebfluxr2dbc.model.entity.Address;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressBuilder {

  public AddressDto toAddressDto(Address address) {
    return new AddressDto(address.getId(), address.getLocation());
  }

}
