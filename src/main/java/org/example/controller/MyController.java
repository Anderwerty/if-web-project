package org.example.controller;

import org.example.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/first", "/second"})
public class MyController extends HttpServlet {

    private static final String CONTENT_TYPE = "text/html";
    private UserService userService;

//
//    public MyController(){
//        this.userService = new UserService();
//    }


    @Override
    public void init() throws ServletException {
        this.userService = new UserService();
        super.init();
    }

    // new Response()
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        resp.setContentType(CONTENT_TYPE);
        String videoHtmlIframe = "            <iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/mOOClonYKmc?si=zcUagVk0JFj6-pB8\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" referrerpolicy=\"strict-origin-when-cross-origin\" allowfullscreen></iframe>";

        try (PrintWriter writer = resp.getWriter()) {
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("  <head>");
            writer.println("      <style>");
            writer.println("          body     {background-color: blue;}");
            writer.println("          h1       {color: red;}");
            writer.println("          iframe   {color: blue;}");
            writer.println("      </style>");
            writer.println("  </head>");
            writer.println("  <body>");
            writer.print("      <h1>");
            writer.print("Dyke Pole");
            writer.print("      </h1>");
            writer.print(videoHtmlIframe);
            writer.println("  </body>");
            writer.println("</html>");
        }
    }
}
