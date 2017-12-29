package com.catchme.catchme.web;

import com.catchme.catchme.common.StateMain;
import com.catchme.catchme.service.game.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/game")
public class GamesController {

    private final
    GameService gameService;

    @Autowired
    public GamesController(GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping(path = "/getGameLeft", method = RequestMethod.GET)
    public StateMain getGameLeft(@RequestParam Long userId) {
        return gameService.getGameLeftRecord(userId);
    }

    @RequestMapping(path = "/getGameRight", method = RequestMethod.GET)
    public StateMain getGameRight(@RequestParam Long userId) {
        return gameService.getGameRightRecord(userId);
    }

    @RequestMapping(path = "/saveGameLeft", method = RequestMethod.POST)
    public StateMain saveGameLeft(@RequestParam Long userId,
                                  @RequestParam Long record) {
        return gameService.saveGameLeftRecord(userId, record);
    }

    @RequestMapping(path = "/saveGameRight", method = RequestMethod.POST)
    public StateMain saveGameRight(@RequestParam Long userId,
                                   @RequestParam Long record) {
        return gameService.saveGameRightRecord(userId, record);
    }
}
