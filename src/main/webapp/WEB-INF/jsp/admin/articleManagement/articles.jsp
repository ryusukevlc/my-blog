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
    
<div class="grid-container">
<div class="grid-x grid-margin-x">
    
    <a class="button" href="/Morgenrot/admin/articles?type=create">作成</a>
    
    <table class="hover">
        <thead>
            <tr>
                <th>title</th>
                <th>content</th>
            </tr>
        </thead>
        <tbody>
             <% if (articles != null && articles.size() > 0) { %>
             <% for(Article article : articles) { %>
                <tr>
                    <td><%= article.getTitle() %></td>
                    <td><%= article.getContent() %></td>
                </tr>
             <%} %>
             <%} else { %>
                <tr>
                    <td>まだ記事が投稿されていません。</td>
                </tr>
             <%} %>
        </tbody>
    </table>
    
    <a href="/Morgenrot/admin/portal">ポータルへ戻る</a>
    
</div>
</div>
    
    <%@ include file="/WEB-INF/jsp/admin/common/footer.jsp" %>
</body>
</html>