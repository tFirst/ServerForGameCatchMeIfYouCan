package com.catchme.catchme.repository;

import com.catchme.catchme.beans.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
    Set<Users> findAll();
    Users findByDeviceId(String deviceId);
}
