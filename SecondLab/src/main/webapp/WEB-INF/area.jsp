<%@ page import="java.util.Objects" %>
<%@ page import="ru.sealoftime.web.secondlab.model.HistoryEntry" %><%--
  Created by IntelliJ IDEA.
  User: Sealofthetime
  Date: 22.01.2021
  Time: 6:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if(Objects.isNull(request.getAttribute("originalUri")))
    response.sendError(403);%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./background.css">
    <link rel="stylesheet" href="./stylesheet.css">
    <jsp:useBean id="history" scope="session" class="ru.sealoftime.web.secondlab.model.History" type="ru.sealoftime.web.secondlab.model.History"/>
</head>
<body>
    <div class="background">
        <div class="front">.</div>
        <div class="back">.</div>
    </div>
    <div id="wrapper" class="card" style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%)">
        <table>
            <thead>
            <tr>
                <td>X: </td>
                <td>Y: </td>
                <td>R: </td>
                <td>isInside: </td>
            </tr>
            <% HistoryEntry entry = history.getHistory().peek(); %>
            <tr style="background-color: <%=entry.getColor()%>cc" data-hash="<%=entry.hashCode()%>">
                <td><%= entry.getX() %></td>
                <td><%= entry.getY() %></td>
                <td><%= entry.getR() %></td>
                <td><%= entry.isInside() %></td>
            </tr>
            </thead>
        </table>
        <input type="submit" value="Go home!" onclick="window.open('./', '_self')">
    </div>
</body>
</html>
