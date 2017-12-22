package com.catchme.catchme.service.game;

import com.catchme.catchme.common.StateMain;

public interface GameService {

    StateMain getGameLeftRecord(Long userId);

    StateMain getGameRightRecord(Long userId);

    StateMain saveGameLeftRecord(Long userId, Long record);

    StateMain saveGameRightRecord(Long userId, Long record);
}
