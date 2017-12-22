package com.catchme.catchme.repository;

import com.catchme.catchme.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {
    Set<User> findAll();
    User findByDeviceId(String deviceId);
}
