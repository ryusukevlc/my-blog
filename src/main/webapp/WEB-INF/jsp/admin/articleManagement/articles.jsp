<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %> 
<%@ page import="model.Article" %>

<%
ArrayList<Article> articles = (ArrayList<Article>) request.getAttribute("articles");
%>   
 
<!DOCTYPE html>
<html>
    <%@ include file="/WEB-INF/jsp/admin/common/head.jsp" %>
<body>
    <%@ include file="/WEB-INF/jsp/admin/common/header.jsp" %>
    <a href="/Morgenrot/admin/articles?type=create">作成</a>
    
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
    
    <a href="/Morgenrot/admin/portal">ポータルへ戻る</a>
    
    <%@ include file="/WEB-INF/jsp/admin/common/footer.jsp" %>
</body>
</html>