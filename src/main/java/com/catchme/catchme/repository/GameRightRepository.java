package com.catchme.catchme.repository;

import com.catchme.catchme.entity.GameRight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface GameRightRepository extends CrudRepository<GameRight, Long> {

    Collection<GameRight> findAll();

    GameRight findByUserId(Long userId);
}
