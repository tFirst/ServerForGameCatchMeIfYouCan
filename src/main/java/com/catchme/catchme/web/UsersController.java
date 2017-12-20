package com.catchme.catchme.web;


import com.catchme.catchme.beans.Users;
import com.catchme.catchme.common.StateMain;
import com.catchme.catchme.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Timestamp;

@RestController
@RequestMapping("/auth/user")
public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    @RequestMapping(method = RequestMethod.GET)
    public StateMain getUser(@RequestParam String deviceId) {
        StateMain stateMain = new StateMain();

        Users user = usersRepository.findByDeviceId(deviceId);

        if (user == null) {
            user = new Users();
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
