<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.sealoftime.web.secondlab.model.HistoryEntry"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./styleshit.css">
    <jsp:useBean id="history" scope="session" class="ru.sealoftime.web.secondlab.model.History" type="ru.sealoftime.web.secondlab.model.History"/>
</head>
<body>
    <output id="error-canvas"></output>
    <canvas id="plot-canvas" width=400 height=400></canvas>
    <form id="form-point" method="post" action="./">
        <fieldset id="x-values">
            <legend>X: </legend>
            <% for(double x=-2; x <= 2; x+=0.5){%>
                <label>
                    <%=x%>
                    <input name="x" type="checkbox" value=<%=x%>>
                </label>
            <%}%>
            <output id="error-x"></output>
        </fieldset>

        <label>Y: <input name="y" id="y-value" type="number" min="-3" max="3" step="0.000000000000001" required>
                  <output id="error-y"></output>
        </label>

        <fieldset id="r-values">
            <legend>R: </legend>
            <% for(double r=1; r <= 3; r+=0.5){%>
                <label>
                    <%=r%>
                    <input type="radio" name="r" value=<%=r%>>
                </label>
            <% } %>
            <output id="error-r"></output>
        </fieldset>

        <input type="submit">
    </form>
    <table id="results-table">
        <thead>
            <tr>
                <td>X: </td>
                <td>Y: </td>
                <td>R: </td>
                <td>isInside: </td>
            </tr>
        </thead>
        <% for(HistoryEntry entry : history.getHistory()){%>
            <tr>
                <td><%= entry.getX() %></td>
                <td><%= entry.getY() %></td>
                <td><%= entry.getR() %></td>
                <td><%= entry.isInside() %></td>
            </tr>
        <% } %>
    </table>
    <script src="./script.js"></script>
</body>
</html>
