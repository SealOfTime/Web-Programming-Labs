<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.sealoftime.web.secondlab.model.HistoryEntry"%>
<html>
<head>
    <title>Title</title>
    <jsp:useBean id="history" scope="session" class="ru.sealoftime.web.secondlab.model.History" type="ru.sealoftime.web.secondlab.model.History"/>
</head>
<body>
    <form method="post" action="./" enctype="application/x-www-form-urlencoded">
        <fieldset>
            <legend>X: </legend>
            <% for(double x=-2; x <= 2; x+=0.5){%>
                <label>
                    <%=x%>
                    <input name="x" type="checkbox" value=<%=x%>>
                </label>
            <%}%>
        </fieldset>

        <label>Y: <input name="y" id="input-y" type="number" min="-3" max="3"></label>

        <fieldset>
            <legend>R: </legend>
            <% for(double r=1; r <= 3; r+=0.5){%>
                <label>
                    <%=r%>
                    <input type="radio" name="r" value=<%=r%>>
                </label>
            <% } %>
        </fieldset>

        <input type="submit">
    </form>
    <table>
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
</body>
</html>
