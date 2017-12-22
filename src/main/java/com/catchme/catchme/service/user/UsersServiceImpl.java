package com.catchme.catchme.service.user;


import com.catchme.catchme.common.StateMain;
import com.catchme.catchme.entity.User;
import com.catchme.catchme.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public StateMain auth(String deviceId) {
        StateMain stateMain = new StateMain();
        User user = usersRepository.findByDeviceId(deviceId);

        if (user == null) {
            user = new User();
            user.setDeviceId(deviceId);
            user.setToken(getToken(deviceId));
            usersRepository.save(user);
            stateMain.setUserId(user.getUserId());
        }

        stateMain.setUserId(user.getUserId());

        return stateMain;
    }

    private static String getToken(String str) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}
