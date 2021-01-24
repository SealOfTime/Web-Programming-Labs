<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.sealoftime.web.secondlab.model.HistoryEntry"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./background.css">
    <link rel="stylesheet" href="./stylesheet.css">
    <jsp:useBean id="history" scope="session" class="ru.sealoftime.web.secondlab.model.History" type="ru.sealoftime.web.secondlab.model.History"/>
    <% double lastRadius = history.getHistory().size() != 0 ? history.getHistory().peek().getR() : 0;%>
</head>
<body id="body" data-new-r="<%=lastRadius%>">
    <div class="background">
        <div class="front">.</div>
        <div class="back">.</div>
    </div>
    <main>
        <div class="card" id="canvas-container">
            <output id="error-canvas"></output>
            <svg id="plot-canvas" width="400" height="400" viewBox="-1.2 -1.2 2.4 2.4" fill="transparent" stroke-width="0.002" >
                <line x1="0" x2="0" y1="-1.2" y2="1.2" stroke="black"></line>
                <polyline points="-0.05 -1.1 0 -1.2 0.05 -1.1" stroke="black"></polyline>
                <line x1="-1.2" x2="1.2" y1="0" y2="0" stroke="black"></line>
                <polyline points="1.1 -0.05 1.2 0 1.1 0.05" stroke="black"></polyline>
                <style>
                    svg line{
                        stroke: black;
                    }
                    #svg-x, #svg-y, svg .vertical-label, svg .horizontal-label{
                        fill: white;
                        stroke: transparent;
                        font-size: 0.1px;
                    }
                    svg .vertical-label{
                        text-anchor: start;
                        alignment-baseline: middle;
                    }
                    svg .horizontal-label{
                        text-anchor: middle;
                    }
                    #second-quarter, #third-quarter, #fourth-quarter{
                        stroke: black;
                        fill: #aaf8
                    }
                    svg circle{
                        stroke-width: 0.005;
                        transform: translate(0, 0);
                        transition: transform 0.3s ease;
                    }
                </style>
                <polygon id="second-quarter" points="-1 0 0 -0.5 0 0"></polygon>
                <rect id="third-quarter" x="-1" y="0" width="1" height="1"></rect>
                <path id="fourth-quarter" d="M0.5 0
                                             A 0.5 0.5,0,0,1, 0 0.5
                                             L0 0 Z"></path>
                <text id="svg-x" x="1.15" y="0.1" font-size="0.1" fill="white" text-anchor="end">X</text>
                <text id="r-x" x="1.0" y="0.1" class="horizontal-label"><%=lastRadius != 0 ? lastRadius : "R"%></text>
                <text id="r-x-half" x="0.5" y="0.1" class="horizontal-label"><%=lastRadius != 0 ? lastRadius/2 : "R/2"%></text>
                <text id="neg-r-x-half" x="-0.5" y="0.1" class="horizontal-label"><%=lastRadius != 0 ? -lastRadius/2 : "-R/2"%></text>
                <text id="neg-r-x" x="-1.0" y="0.1" class="horizontal-label"><%=lastRadius != 0 ? -lastRadius : "-R"%></text>
                <text id="svg-y" x="0.1" y="-1.15" font-size="0.1" fill="white" text-anchor="end" alignment-baseline="hanging">Y</text>
                <text id="r-y" class="vertical-label" x="0.05" y="-1.0"><%=lastRadius != 0 ? lastRadius : "R"%></text>
                <text id="r-y-half" class="vertical-label" x="0.05" y="-0.5"><%=lastRadius != 0 ? lastRadius/2 : "R/2"%></text>
                <text id="neg-r-y-half" class="vertical-label" x="0.05" y="0.5"><%=lastRadius != 0 ? -lastRadius/2 : "-R/2"%></text>
                <text id="neg-r-y" class="vertical-label" x="0.05" y="1.0"><%=lastRadius != 0 ? -lastRadius : "-R"%></text>
                <% for(HistoryEntry point : history.getHistory()){ %>
                    <circle cx="0" cy="0" r="0.02"
                            data-x="<%=point.getX()%>" data-y="<%=point.getY()%>" data-r="<%=point.getR()%>"
                            data-hash="<%=point.hashCode()%>"
                            fill="<%=point.getColor()%>" stroke="<%=point.isInside() ? "green" : "red"%>">
                    </circle>
                <%}%>
            </svg>
<%--            <canvas id="plot-canvas" width=400 height=400></canvas>--%>
        </div>

        <form class="card" id="form-point" method="post" action="./">
            <div id="x-values" class="field">
                <span>X: </span>
                <ul>
                <% for(double x=-2; x <= 2; x+=0.5){%>
                    <li>
                        <input id="x<%=x%>" name="x" type="checkbox" value=<%=x%>>
                        <label for="x<%=x%>"><%=x%></label>
                    </li>
                <%}%>
                </ul>
                <output id="error-x"></output>
            </div>

            <label class="field">Y: <input name="y" id="y-value" type="number" min="-3" max="3" step="0.000000000000001" required>
                      <output id="error-y"></output>
            </label>

            <div id="r-values" class="field">
                <span>R: </span>
                <ul>
                    <% for(double r=1; r <= 3; r+=0.5){%>
                        <li>
                            <input id="r<%=r%>" type="radio" name="r" value=<%=r%> <%=r == lastRadius ? "checked" : ""%>>
                            <label for="r<%=r%>"><%=r%></label>
                        </li>
                    <% } %>
                </ul>
                <output id="error-r"></output>
            </div>

            <input type="submit">
        </form>
        <table id="results-table" class="card">
            <thead>
                <tr>
                    <td>X: </td>
                    <td>Y: </td>
                    <td>R: </td>
                    <td>isInside: </td>
                </tr>
            </thead>
            <% for(HistoryEntry entry : history.getHistory()){%>
                <tr class="point-entry" style="background-color: <%=entry.getColor()%>cc" data-hash="<%=entry.hashCode()%>">
                    <td><%= entry.getX() %></td>
                    <td><%= entry.getY() %></td>
                    <td><%= entry.getR() %></td>
                    <td><%= entry.isInside() %></td>
                </tr>
            <% } %>
        </table>
        <div id="modal" class="card">
            <p id="content"></p>
            <a id="close" href="#" onclick="closeModal()">x</a>
        </div>
    </main>
<%--    <script src="./script.js"></script>--%>
    <script src="./newScript.js"></script>
</body>
</html>
