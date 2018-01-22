package com.catchme.catchme.controller;

import com.catchme.catchme.common.StateMain;
import com.catchme.catchme.service.game.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/game", produces = {"application/json; charset=UTF-8"})
public class GamesController {

    private final GameService gameService;

    @Autowired
    public GamesController(GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping(value = "/getGameLeft", method = RequestMethod.GET)
    public StateMain getGameLeft(@RequestParam("userId") Long userId) {
        return gameService.getGameLeftRecord(userId);
    }

    @RequestMapping(value = "/getGameRight", method = RequestMethod.GET)
    public StateMain getGameRight(@RequestParam("userId") Long userId) {
        return gameService.getGameRightRecord(userId);
    }

    @RequestMapping(value = "/saveGameLeft", method = RequestMethod.POST)
    public StateMain saveGameLeft(@RequestParam("userId") Long userId, @RequestParam("record") Long record) {
        return gameService.saveGameLeftRecord(userId, record);
    }

    @RequestMapping(value = "/saveGameRight", method = RequestMethod.POST)
    public StateMain saveGameRight(@RequestParam("userId") Long userId, @RequestParam("record") Long record) {
        return gameService.saveGameRightRecord(userId, record);
    }
}
