package com.catchme.catchme.repository;

import com.catchme.catchme.beans.GameLeft;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface GameLeftRepository extends CrudRepository<GameLeft, Long> {
    Set<GameLeft> findAll();
    GameLeft findByUserId(Long userId);
}
