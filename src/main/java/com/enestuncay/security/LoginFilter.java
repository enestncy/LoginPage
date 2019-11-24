package com.enestuncay.security;


import com.enestuncay.controller.HomeController;
import com.enestuncay.entity.User;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginFilter implements Filter {

    public static User user;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;

        user = (User)req.getSession().getAttribute("user");


        if(user != null) {//if user logged in , do not apply filter for below RequestURI

            if(req.getRequestURI().contains("logout")){
                chain.doFilter(request, response);
                return;
            }

            if(req.getRequestURI().contains("index")){
                chain.doFilter(request, response);
                return;
            }

            //redirect to index for other RequestURI's
            res.sendRedirect(HomeController.url + "/index");
            chain.doFilter(request, response);
            return;
        }
        else {//if user has not log in yet, do not apply filter for below RequestURI

            if(req.getRequestURI().contains("login")) {
                chain.doFilter(request, response);
                return;
            }

            if(req.getRequestURI().contains("register")) {
                chain.doFilter(request, response);
                return;
            }


            if(req.getRequestURI().contains("addUser")){
                chain.doFilter(request, response);
                return;
            }

            if(req.getRequestURI().contains("controlUser")){
                chain.doFilter(request, response);
                return;
            }

            //redirect to login for other RequestURI's
            res.sendRedirect(HomeController.url + "/login");
            chain.doFilter(request, response);
            return;
        }
    }
}

