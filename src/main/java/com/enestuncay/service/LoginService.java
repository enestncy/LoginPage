package com.enestuncay.service;


import com.enestuncay.entity.User;
import org.apache.commons.codec.digest.DigestUtils;

public class LoginService {

    //comparison of password and reentered password while registering
    public boolean controlPasswords(User user){
        if(user.getHashPassword().equals(user.getCtrlPass()))
            return true;
        return false;
    }

    //password hashing method
    public String hashPassword(String password){

        String hashedPass= DigestUtils.sha256Hex(password);
        return hashedPass;
    }
}
