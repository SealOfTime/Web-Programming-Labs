package ru.sealoftime.web.secondlab;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var x = req.getParameter("x");
        var y = req.getParameter("y");
        var r = req.getParameter("r");

        //System.out.println(req.getMethod());
        if(x != null || y != null || r != null)
            req.getRequestDispatcher("/area").forward(req, resp);
        else
            getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
     //   super.service(req, resp);
    }
}
