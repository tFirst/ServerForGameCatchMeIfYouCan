package com.catchme.catchme.service.game;

import com.catchme.catchme.common.StateMain;
import com.catchme.catchme.entity.GameLeft;
import com.catchme.catchme.entity.GameRight;
import com.catchme.catchme.repository.GameLeftRepository;
import com.catchme.catchme.repository.GameRightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GameServiceImpl implements GameService {

    final private GameLeftRepository gameLeftRepository;

    final private GameRightRepository gameRightRepository;

    @Autowired
    public GameServiceImpl(GameLeftRepository gameLeftRepository, GameRightRepository gameRightRepository) {
        this.gameLeftRepository = gameLeftRepository;
        this.gameRightRepository = gameRightRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public StateMain getGameLeftRecord(Long userId) {
        try {
            StateMain stateMain = new StateMain();

            GameLeft gameLeft = gameLeftRepository.findByUserId(userId);

            stateMain.setUserId(userId);

            if (gameLeft == null) {
                stateMain.setGameLeftRecord(0L);
            } else {
                stateMain.setGameLeftRecord(gameLeft.getRecordValue());
            }

            System.out.println("test commit1");

            return stateMain;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    @Transactional(readOnly = true)
    @Override
    public StateMain getGameRightRecord(Long userId) {
        try {
            StateMain stateMain = new StateMain();

            GameRight gameRight = gameRightRepository.findByUserId(userId);

            stateMain.setUserId(userId);

            if (gameRight == null) {
                stateMain.setGameLeftRecord(0L);
            } else {
                stateMain.setGameLeftRecord(gameRight.getRecordValue());
            }

            System.out.println("test commit1");

            return stateMain;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    @Transactional
    @Override
    public StateMain saveGameLeftRecord(Long userId, Long record) {
        StateMain stateMain = new StateMain();

        GameLeft gameLeft = gameLeftRepository.findByUserId(userId);

        if (gameLeft != null) {
            if (record.compareTo(gameLeft.getRecordValue()) > 0) {
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
            if (record.compareTo(gameRight.getRecordValue()) > 0) {
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
