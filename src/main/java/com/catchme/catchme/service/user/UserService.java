package com.catchme.catchme.service.user;

import com.catchme.catchme.common.StateMain;

public interface UserService {

    StateMain auth(final String deviceId);
}
