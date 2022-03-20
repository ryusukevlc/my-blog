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
    
     <% if (articles != null && articles.size() > 0) { %>
    <% for(Article article : articles) { %>
        <div>
            <p><%= article.getTitle() %></p>
            <p><%= article.getContent() %></p>
        </div>
    <%} %>
    <%} else { %>
        <div>
            <p>まだ記事が投稿されていません。</p>
        </div>
    <%} %>
    
</body>
</html>