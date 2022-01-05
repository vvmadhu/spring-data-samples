package com.hcl.dna.poc;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyRepository extends CrudRepository<MyEntity, Integer> {
    @Override
    Optional<MyEntity> findById(Integer integer);
}
