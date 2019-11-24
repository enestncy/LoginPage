package com.enestuncay.controller;

import com.enestuncay.entity.User;
import com.enestuncay.security.LoginFilter;
import com.enestuncay.service.LoginService;
import com.enestuncay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class HomeController {

    public static String url = "http://localhost:8080";

    //data holders for user access count
    private String username = "";
    private int count = 3;

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    //------------------------------------LOGIN PAGE------------------------------------

    // if mapped {"" , "/" , "login"} then go into login page
    @GetMapping(value = {"" , "/" , "/login"})
    public String login(HttpServletRequest request) {

        return "login";
    }

    //login button
    @PostMapping(value = {"/controlUser"})
    public ResponseEntity<String> controlUser(@RequestBody User user, HttpServletRequest request) {

        //hash entered user password
        user.setHashPassword(loginService.hashPassword(user.getHashPassword()));

        //Read user in database by entered username
        User userLogin = userService.getUserByCustomerId(user.getCustomerId());

        //if new entered username does not match the previous entered username then reset data holders
        if(!username.equals(user.getCustomerId())){
            username = user.getCustomerId();
            count = 3;
        }


        //if user exists then login
        if(userLogin != null) {

            //if user had deleted , do not login //deleted user is inactive(state = 3) in database
            if (userLogin.getState() == 3) {return new ResponseEntity<String>("INACTIVE", HttpStatus.OK);}
            //if user had blocked , do not login //blocked user state = 3 in database
            else if (userLogin.getState() == 2) {return new ResponseEntity<String>("BLOCKED", HttpStatus.OK);}

            else{

                //if customerId and password are not correct then decrease user access count
                if (!userLogin.getHashPassword().equals(user.getHashPassword())) {
                    System.out.println("girdi");
                    count--;
                    if(count == 0){
                        userLogin.setState(2);
                        userService.updateUser(userLogin);
                    }
                    return new ResponseEntity<String>("ERR_PASS", HttpStatus.CREATED);
                }
                //if customerId and password are correct then login
                else {

                    userLogin.setLastLoginTime(new Date());
                    userService.updateUser(userLogin);
                    request.getSession().setAttribute("user", userLogin);
                    username = "";
                    count = 3;
                    return new ResponseEntity<String>("OK", HttpStatus.OK);
                }
            }
        }

        return new ResponseEntity<String>("ERROR",HttpStatus.OK);
    }

    //------------------------------------REGISTER PAGE------------------------------------

    //if clicked on register button or mapped "register" then go into register page
    @GetMapping(value = {"/register"})
    public String index(HttpServletRequest request) {return "register"; }

    //register button
    @PostMapping(value = {"/addUser"})
    public ResponseEntity<String> addUser(@RequestBody User user , HttpServletRequest request){

        if(user.getCustomerId().equals("")){return new ResponseEntity<String>("ERR_USERNAME2" , HttpStatus.CREATED);}
        //check if password areas filled out
        if(user.getHashPassword().equals("") || user.getCtrlPass().equals("")){return new ResponseEntity<String>("ERR_PASS2" , HttpStatus.CREATED);}
        //check if password and reentered password matches with each other
        if(!loginService.controlPasswords(user)){return new ResponseEntity<String>("ERR_PASS" , HttpStatus.CREATED);}
        //check if the username(customerId) already exists in database
        if(userService.getUserByCustomerId(user) != null){return new ResponseEntity<String >("ERR_USERNAME", HttpStatus.CREATED);}
        //check if user saved database successfully
        if(userService.saveUser(user)){return new ResponseEntity<String>("OK" , HttpStatus.CREATED);}

        return new ResponseEntity<String>("ERROR" , HttpStatus.CREATED);
    }

    //------------------------------------USER INDEX PAGE------------------------------------

    @GetMapping(value = {"/index"})
    public String index(Model model , HttpServletRequest request) {

        model.addAttribute("user",request.getSession().getAttribute("user"));
        return "index";
    }

    @GetMapping(value = "/logout")
    public String logout(Model model , HttpServletRequest request) {

        System.out.println("logout");
        request.getSession().setAttribute("user", null);
        return "redirect:/login";
    }

    @GetMapping(value = "/deleteUser")
    public String deleteUser(HttpServletRequest request) {

        User user = userService.getUserByCustomerId(LoginFilter.user.getCustomerId());
        user.setState(3);
        userService.updateUser(user);

        request.getSession().setAttribute("user", null);

        return "login";
    }

    @GetMapping(value = "/process")
    public ResponseEntity<HttpStatus> process(HttpServletRequest request) {

        User user = userService.getUserByCustomerId(LoginFilter.user.getCustomerId());
        user.setLastUpdateTime(new Date());
        userService.updateUser(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
