package ru.sealoftime.web.secondlab;

import ru.sealoftime.web.secondlab.model.Point;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.validation.Validator;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AreaCheckValidatorFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) { }

    @Resource
    private Validator validator;

    private final static List<Double> possibleRadius = List.of(1d, 1.5d, 2d, 2.5d, 3d);

    @Override
    @SuppressWarnings("unchecked")
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        var errors = (Map<String, String>) request.getAttribute("errors");
        if (Objects.isNull(errors))
            errors = new HashMap<>();

        System.out.println("Starting validation!");

        var point = (Point) request.getAttribute("point");
        if(point != null) {
            for (var violation : validator.validate(point))//TODO: do not couple property name to the request parameter name
                errors.put(violation.getPropertyPath().toString(), violation.getMessage());
        }

        var radius = (Double) request.getAttribute("radius");
        if(radius != null && !possibleRadius.contains(radius)) //TODO: normal validation
            errors.put("r", "Radius must be one of 1, 1.5, 2, 2.5, 3");

        request.setAttribute("errors", errors);
        chain.doFilter(request, response);
        System.out.println("Validation done!");
    }

    @Override
    public void destroy() {

    }
}
