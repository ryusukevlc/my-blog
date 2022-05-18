<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.article.Article" %>

<%
Article article = (Article)request.getAttribute("article");
int weather = (int)request.getAttribute("weather");
%>
    
<!DOCTYPE html>
<html>
    <%@ include file="/WEB-INF/jsp/viewerCommon/head.jsp" %>
<body>
    <jsp:include page="/WEB-INF/jsp/viewerCommon/header.jsp">
          <jsp:param name="weather" value="<%=weather %>" />
    </jsp:include>

    <div class="grid-container" style="min-height: 100vh;">
        <div class="grid-x grid-margin-x" style="">
            <p class="cell small-2" style="">作成日：<%= article.getCreated_at() %></p>
            <% if (article.getUpdated_at() != null) { %>
                <p class="cell small-2" style="">更新日：<%= article.getUpdated_at() %></p>
            <% } %>
        </div>
        <h3 class="cell" style="text-align: center;"><%= article.getTitle() %></h3>
        <div class="cell" style="text-align: center;">
            <%= article.getContent() %>
        </div>
    </div>
    



    <%@ include file="/WEB-INF/jsp/viewerCommon/footer.jsp" %>
</body>
</html>