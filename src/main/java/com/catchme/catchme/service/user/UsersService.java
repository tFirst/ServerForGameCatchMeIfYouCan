package com.catchme.catchme.service.user;

import com.catchme.catchme.common.StateMain;
import com.catchme.catchme.entity.User;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface UsersService {

    Collection<User> findAll();

    StateMain auth(String deviceId);
}
