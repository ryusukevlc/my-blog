<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.article.Article" %>

<%
Article article = (Article)request.getAttribute("article");
%>
    
<!DOCTYPE html>
<html>
    <%@ include file="/WEB-INF/jsp/viewerCommon/head.jsp" %>
<body>
    <%@ include file="/WEB-INF/jsp/viewerCommon/header.jsp" %>


        <h4><%= article.getTitle() %></h4>
        <p><%= article.getContent() %></p>
    



    <%@ include file="/WEB-INF/jsp/viewerCommon/footer.jsp" %>
</body>
</html>