package com.catchme.catchme.repository;

import com.catchme.catchme.entity.GameRight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface GameRightRepository extends CrudRepository<GameRight, Long> {
    Set<GameRight> findAll();
    GameRight findByUserId(Long userId);
}
