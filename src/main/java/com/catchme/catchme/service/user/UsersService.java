package com.catchme.catchme.service.user;

import com.catchme.catchme.common.StateMain;

public interface UsersService {

    StateMain auth(String deviceId);
}
