package com.ds.ds.domain.user.util;

import com.ds.ds.domain.user.domain.entity.User;

public interface UserUtil {
    User findUserByEmail(String email);

    void checkPassword(String userPassword,String password);
    User currentUser();
}
