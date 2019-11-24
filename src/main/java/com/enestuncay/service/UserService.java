package com.enestuncay.service;

import com.enestuncay.dao.UserDAO;
import com.enestuncay.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;


@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private LoginService loginService;

    //save user
    public boolean saveUser(User user){

        //hashing user password and reentered password
        user.setHashPassword(loginService.hashPassword(user.getHashPassword()));
        user.setCtrlPass(loginService.hashPassword(user.getCtrlPass()));
        user.setHashType("sha256");

        //at registering set user state as active
        user.setState(1);

        //save user and if it is successful then return true , if not return false
        userDAO.insert(user);
        if(getUserByCustomerId(user) != null){return true;}
        return false;
    }
    //update user
    public void updateUser(User user) {userDAO.update(user);}

    //delete user
    public void  deleteUser(User user){userDAO.delete(user); }

    //get user by CustomerId and Password
    public User getUserByCustomerIdAndPassword(User user) {return userDAO.getUser(user.getCustomerId(), user.getHashPassword());}

    //get user by CustomerId with user object
    public User getUserByCustomerId(User user) {return userDAO.getUser(user.getCustomerId());}

    //get user by CustomerId by string
    public User getUserByCustomerId(String customerId) {return userDAO.getUser(customerId);}
}
