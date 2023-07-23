package com.dev.gam.mswebfluxr2dbc.business;

import com.dev.gam.mswebfluxr2dbc.model.dto.AddressDto;
import com.dev.gam.mswebfluxr2dbc.model.dto.LibraryDto;
import com.dev.gam.mswebfluxr2dbc.model.entity.Address;
import com.dev.gam.mswebfluxr2dbc.model.entity.Library;
import org.springframework.stereotype.Component;

@Component
public class LibraryBuilder {

  public LibraryDto toLibraryDto(Library library, Address address) {
    return new LibraryDto(library.getId(),library.getName(),
        new AddressDto(address.getId(), address.getLocation()));
  }
}
