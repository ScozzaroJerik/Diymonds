package com.javasampleapproach.diymonds.repo;

import com.javasampleapproach.diymonds.model.Fornitore;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FornitoreRepository extends CrudRepository<Fornitore, Long> {

    @Override
    Optional<Fornitore> findById(Long aLong);
}
