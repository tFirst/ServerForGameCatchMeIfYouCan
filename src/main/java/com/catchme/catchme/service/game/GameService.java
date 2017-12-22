package com.catchme.catchme.service.game;

import com.catchme.catchme.common.StateMain;
import org.springframework.stereotype.Service;

@Service
public interface GameService {

    StateMain getGameLeftRecord(Long userId);

    StateMain getGameRightRecord(Long userId);

    StateMain saveGameLeftRecord(Long userId, Long record);

    StateMain saveGameRightRecord(Long userId, Long record);
}
