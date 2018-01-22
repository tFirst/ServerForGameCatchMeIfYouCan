package com.catchme.catchme.service.user;


import com.catchme.catchme.common.StateMain;
import com.catchme.catchme.entity.User;
import com.catchme.catchme.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.MessageDigest;

@Service
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Transactional
    @Override
    public StateMain auth(final String deviceId) {
        try {
            StateMain stateMain = new StateMain();
            User user = usersRepository.findByDeviceId(deviceId);

            if (user == null) {
                user = new User();
                user.setDeviceId(deviceId);
                user.setToken(getToken(deviceId));
                usersRepository.save(user);
            }

            stateMain.setUserId(user.getUserId());

            return stateMain;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    private static String getToken(String str) {
        try {
            String generatedPassword;
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
            return generatedPassword;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
}
