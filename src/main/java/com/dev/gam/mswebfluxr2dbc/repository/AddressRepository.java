package com.dev.gam.mswebfluxr2dbc.repository;

import com.dev.gam.mswebfluxr2dbc.model.entity.Address;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends ReactiveCrudRepository<Address, Long> {

}
