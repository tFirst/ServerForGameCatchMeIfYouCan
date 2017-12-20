package com.catchme.catchme.web;

import com.catchme.catchme.beans.GameLeft;
import com.catchme.catchme.beans.GameRight;
import com.catchme.catchme.common.StateMain;
import com.catchme.catchme.repository.GameLeftRepository;
import com.catchme.catchme.repository.GameRightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/game")
public class GamesController {

    @Autowired
    GameLeftRepository gameLeftRepository;

    @Autowired
    GameRightRepository gameRightRepository;

    @RequestMapping(path = "/getGameLeft", method = RequestMethod.GET)
    public StateMain getGameLeft(@RequestParam Long userId) {
        StateMain stateMain = new StateMain();

        GameLeft gameLeft = gameLeftRepository.findByUserId(userId);

        if (gameLeft != null) {
            stateMain.setGameLeftRecord(gameLeft.getRecordValue());
            return stateMain;
        }

        return stateMain;
    }

    @RequestMapping(path = "/getGameRight", method = RequestMethod.GET)
    public StateMain getGameRight(@RequestParam Long userId) {
        StateMain stateMain = new StateMain();

        GameRight gameRight = gameRightRepository.findByUserId(userId);

        if (gameRight != null) {
            stateMain.setGameRightRecord(gameRight.getRecordValue());
            return stateMain;
        }

        return stateMain;
    }

    @RequestMapping(path = "/saveGameLeft", method = RequestMethod.GET)
    public StateMain saveGameLeft(@RequestParam Long userId,
                                  @RequestParam Long record) {
        StateMain stateMain = new StateMain();

        GameLeft gameLeft = gameLeftRepository.findByUserId(userId);

        if (gameLeft != null) {
            if (record > gameLeft.getRecordValue())
            gameLeft.setRecordValue(record);
            gameLeftRepository.save(gameLeft);
            stateMain.setStatus(HttpStatus.OK);

            return stateMain;
        }

        gameLeft = new GameLeft();
        gameLeft.setUserId(userId);
        gameLeft.setRecordValue(record);
        gameLeftRepository.save(gameLeft);

        stateMain.setStatus(HttpStatus.OK);

        return stateMain;
    }

    @RequestMapping(path = "/saveGameRight", method = RequestMethod.GET)
    public StateMain saveGameRight(@RequestParam Long userId,
                                   @RequestParam Long record) {
        StateMain stateMain = new StateMain();

        GameRight gameRight = gameRightRepository.findByUserId(userId);

        if (gameRight != null) {
            if (record > gameRight.getRecordValue())
                gameRight.setRecordValue(record);
            gameRightRepository.save(gameRight);

            stateMain.setStatus(HttpStatus.OK);

            return stateMain;
        }

        gameRight = new GameRight();
        gameRight.setUserId(userId);
        gameRight.setRecordValue(record);
        gameRightRepository.save(gameRight);

        stateMain.setStatus(HttpStatus.OK);

        return stateMain;
    }
}
