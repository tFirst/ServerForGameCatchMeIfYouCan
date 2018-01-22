package com.catchme.catchme.repository;

import com.catchme.catchme.entity.GameLeft;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface GameLeftRepository extends CrudRepository<GameLeft, Long> {

    Collection<GameLeft> findAll();

    GameLeft findByUserId(Long userId);
}
