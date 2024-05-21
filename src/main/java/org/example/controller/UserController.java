package org.example.controller;


import org.example.entity.User;
import org.example.injector.ApplicationContextHolder;
import org.example.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

// GET: all users   ---/users/all
// GET: user by id  --/users/byId
// GET: registration form --/users/form
// POST: register         --/users/form
@WebServlet({"/users/all", "/users/byId", "/users/form"})
public class UserController extends HttpServlet {

    private final UserService userService =
            ApplicationContextHolder.getInstance(UserService.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        if (requestURI.endsWith("/users/all")) {

            //TODO:
            List<User> users = userService.findAll();
            req.setAttribute("users", users);

            req.getRequestDispatcher("/users.jsp").forward(req, resp);
            return;
        }

        //.../users/byId?userId=1
        if (requestURI.endsWith("/users/byId")) {
            ;
            ;
            ;
            ;
            //TODO;
            String userId = req.getParameter("userId");
            int id = Integer.parseInt(userId);
            User user = userService.findById(id);
            req.setAttribute("user", user);
            return;
        }

        if (requestURI.endsWith("users/form")) {
            //TODO:
        }
    }
}
