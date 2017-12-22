package com.catchme.catchme.service.game;

import com.catchme.catchme.common.StateMain;
import com.catchme.catchme.entity.GameLeft;
import com.catchme.catchme.entity.GameRight;
import com.catchme.catchme.repository.GameLeftRepository;
import com.catchme.catchme.repository.GameRightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class GameServiceImpl implements GameService {

    @Autowired
    GameLeftRepository gameLeftRepository;

    @Autowired
    GameRightRepository gameRightRepository;

    @Override
    public StateMain getGameLeftRecord(Long userId) {
        StateMain stateMain = new StateMain();

        GameLeft gameLeft = gameLeftRepository.findByUserId(userId);

        if (gameLeft != null) {
            stateMain.setGameLeftRecord(gameLeft.getRecordValue());
            return stateMain;
        }

        stateMain.setGameLeftRecord(0L);

        return stateMain;
    }

    @Override
    public StateMain getGameRightRecord(Long userId) {
        StateMain stateMain = new StateMain();

        GameRight gameRight = gameRightRepository.findByUserId(userId);

        if (gameRight != null) {
            stateMain.setGameRightRecord(gameRight.getRecordValue());
            return stateMain;
        }

        stateMain.setGameRightRecord(0L);

        return stateMain;
    }

    @Override
    public StateMain saveGameLeftRecord(Long userId, Long record) {
        StateMain stateMain = new StateMain();

        GameLeft gameLeft = gameLeftRepository.findByUserId(userId);

        if (gameLeft != null) {
            if (record > gameLeft.getRecordValue()) {
                gameLeft.setRecordValue(record);
                gameLeftRepository.save(gameLeft);

                stateMain.setStatus(HttpStatus.OK);

                return stateMain;
            } else {
                stateMain.setStatus(HttpStatus.CONFLICT);
                return stateMain;
            }
        }

        gameLeft = new GameLeft();
        gameLeft.setUserId(userId);
        gameLeft.setRecordValue(record);
        gameLeftRepository.save(gameLeft);

        stateMain.setStatus(HttpStatus.OK);

        return stateMain;
    }

    @Override
    public StateMain saveGameRightRecord(Long userId, Long record) {
        StateMain stateMain = new StateMain();

        GameRight gameRight = gameRightRepository.findByUserId(userId);

        if (gameRight != null) {
            if (record > gameRight.getRecordValue()) {
                gameRight.setRecordValue(record);
                gameRightRepository.save(gameRight);

                stateMain.setStatus(HttpStatus.OK);

                return stateMain;
            } else {
                stateMain.setStatus(HttpStatus.CONFLICT);
                return stateMain;
            }
        }

        gameRight = new GameRight();
        gameRight.setUserId(userId);
        gameRight.setRecordValue(record);
        gameRightRepository.save(gameRight);

        stateMain.setStatus(HttpStatus.OK);

        return stateMain;
    }
}
