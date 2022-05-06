<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="model.article.Article"%>
<%@ page import="java.util.List"  %>
    
<%

Article article = (Article)request.getAttribute("article");

int id = (int)request.getAttribute("id");

List<String> errors = (List<String>)request.getAttribute("errors");
%>
    
<!DOCTYPE html>
<html>
   <%@ include file="/WEB-INF/jsp/admin/common/head.jsp" %>
<body>
    <%@ include file="/WEB-INF/jsp/admin/common/header.jsp" %>
    <div class="grid-container">
    
    <form action="/Morgenrot/admin/articleManagement/articleEdit" method="post">
        <label for="title">タイトル</label>
        <input type="text" name="title" placeholder="タイトル" value="<%= article.getTitle() %>">
        <label for="content" class="padding-3">内容</label>
        <textarea rows="20" cols="" name="content" placeholder="内容"><%= article.getContent() %></textarea>
        <input type="hidden" name="id" value="<%= id%>">
        <input type="submit" value="完了" class="button">
    </form>
    
    <% if (errors != null && !errors.isEmpty()) { %>
        <% for (String error : errors) { %>
            <p><%= error %></p>
        <% } %>
    <% } %>
    
    <a href="/Morgenrot/admin/articleManagement/articles">記事管理画面に戻る</a>
    
    </div>
    <%@ include file="/WEB-INF/jsp/admin/common/footer.jsp" %>
</body>
</html>