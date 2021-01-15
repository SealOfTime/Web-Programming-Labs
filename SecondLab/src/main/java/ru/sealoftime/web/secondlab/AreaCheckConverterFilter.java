package ru.sealoftime.web.secondlab;

import ru.sealoftime.web.secondlab.model.Point;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class AreaCheckConverterFilter implements Filter {

    private FilterConfig config;

    @Override
    public void init(FilterConfig filterConfig) {
        this.config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        @SuppressWarnings("unchecked")
        var errors = (Map<String, String>) request.getAttribute("errors");
        if(errors == null) {
            errors = new HashMap<>();
            request.setAttribute("errors", errors);
        }

        System.out.println("Starting conversion");

        var x = convert("x", request);
        var y = convert("y", request);

        if(x.isPresent() && y.isPresent())
            request.setAttribute("point", new Point(x.get(), y.get()));

        var r = convert("r", request);
        r.ifPresent(radius -> request.setAttribute("radius", radius));

        chain.doFilter(request, response);
        System.out.println("Conversion done!");
    }

    //TODO: Ideally turn into Converter interface/service
    @SuppressWarnings("unchecked")
    private Optional<Double> convert(String parameter, ServletRequest from) {
        try {
            return Optional.of(
                    Double.valueOf(
                            from.getParameter(parameter)));
        } catch (NumberFormatException | NullPointerException e) {
            var errors = (Map<String, String>) from.getAttribute("errors");
            errors.put(parameter, config.getInitParameter("error.nan"));
            from.setAttribute("errors", errors);
        }
        return Optional.empty();
    }

    @Override
    public void destroy() { }
}
