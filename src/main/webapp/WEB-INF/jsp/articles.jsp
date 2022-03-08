<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %> 
<%@ page import="model.Article" %>

<%
ArrayList<Article> articles = (ArrayList<Article>) request.getAttribute("articles");
%>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Morgenrot</title>
</head>
<body>
    <h1>Morgenrot</h1>
     
    <% for(Article article : articles) { %>
        <div>
            <p><%= article.getTitle() %></p>
            <p><%= article.getContent() %></p>
        </div>
    <%} %>
    
</body>
</html>