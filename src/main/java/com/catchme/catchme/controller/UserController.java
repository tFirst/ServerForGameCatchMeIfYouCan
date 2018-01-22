package com.catchme.catchme.controller;


import com.catchme.catchme.common.StateMain;
import com.catchme.catchme.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth/user", produces = {"application/json; charset=UTF-8"})
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public StateMain getUser(@RequestParam("deviceId") String deviceId) {
        return userService.auth(deviceId);
    }
}
