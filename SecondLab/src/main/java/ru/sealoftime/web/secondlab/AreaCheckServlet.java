package ru.sealoftime.web.secondlab;


import ru.sealoftime.web.secondlab.model.History;
import ru.sealoftime.web.secondlab.services.HistoryService;
import ru.sealoftime.web.secondlab.model.HistoryEntry;
import ru.sealoftime.web.secondlab.model.Point;
import ru.sealoftime.web.secondlab.services.AreaService;
import ru.sealoftime.web.secondlab.services.JSONViews;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@MultipartConfig
@WebServlet(urlPatterns = "/area", name="AreaCheckServlet")
public class AreaCheckServlet extends HttpServlet {

    private @EJB JSONViews jsonView;
//    private @EJB HistoryService historyService;
    private @EJB AreaService areaService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        @SuppressWarnings("unchecked")
        var errors = (Map<String, String>) req.getAttribute("errors");
        System.out.println(errors);

        resp.setContentType("application/json");
        if(Objects.nonNull(errors) && errors.isEmpty()){
            var point = (Point) req.getAttribute("point");
            System.out.println(point);
            var areaRadius = (Double) req.getAttribute("radius");
            System.out.println(areaRadius);
            var area = areaService.constructArea(areaRadius);
            System.out.println(area);

            var result = area.checkIfContains(point);
            var entry = new HistoryEntry(point.getX(), point.getY(), areaRadius, result);

            var history = (History) req.getSession().getAttribute("history");
            if(history == null){
                history = new History();
                req.getSession().setAttribute("history", history);
            }
            history.push(entry);

            resp.setStatus(200);
            resp.getWriter().write(jsonView.generatePointResponse(entry));
        }else {
            resp.setStatus(400);
            if(errors == null)
                resp.getWriter().write(jsonView.generateErrorMessageForNullErrors());
            else
                resp.getWriter().write(jsonView.generateErrorMessages(errors));
        }
    }
}
