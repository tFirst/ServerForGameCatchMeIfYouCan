package com.catchme.catchme.repository;

import com.catchme.catchme.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {

    Collection<User> findAll();

    User findByDeviceId(String deviceId);
}
