package com.javasampleapproach.diymonds.repo;

import com.javasampleapproach.diymonds.model.Venditore;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VenditoreRepository extends CrudRepository<Venditore, Long> {

    @Override
    Optional<Venditore> findById(Long aLong);
}
