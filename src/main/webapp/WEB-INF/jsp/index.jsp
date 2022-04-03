<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.ArrayList" %> 
<%@ page import="model.article.Article" %>

<%
ArrayList<Article> articles = (ArrayList<Article>) request.getAttribute("articles");
%>   

<!DOCTYPE html>
<html>
  <%@ include file="/WEB-INF/jsp/admin/common/head.jsp" %>
<body>
    <h1>Morgenrot</h1>
    
    <!-- 取得した記事を表示する -->
     <% if (articles != null && articles.size() > 0) { %>
     <div class="grid-container">
     <div class="grid-x grid-margin-x small-up-3 ">
    <% for(Article article : articles) { %>
        <div class="cell">
            <div class="card">
                <div class="card-divider">
                </div>
                <div class="card-section">
                    <h5><%= article.getTitle() %></h5>
                    <p><%= article.getContent() %></p>
                </div>
            </div>
        </div>
    <%} %>
     </div>
     </div>
    <%} else { %>
        <div>
            <p>まだ記事が投稿されていません。</p>
        </div>
    <%} %>
    <a href="/Morgenrot/admin/portal">管理者</a>
</body>
</html>