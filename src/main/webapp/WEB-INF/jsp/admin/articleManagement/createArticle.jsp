<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List" %>

<%
List<String> errors =(List<String>)request.getAttribute("errors");
%>

    
<!DOCTYPE html>
<html>
    <%@ include file="/WEB-INF/jsp/admin/common/head.jsp" %>
<body>
    <%@ include file="/WEB-INF/jsp/admin/common/header.jsp" %>
    <div class="grid-container">
    <h4>記事作成</h4>
    
    <form action="/admin/articleManagement/articleCreate" method="post">
        <input type="text" name="title" placeholder="タイトル">
        <textarea rows="20" cols="" name="content" placeholder="内容"></textarea>
        <input type="hidden" name="type" value="create">
        <button class="button" type="button" onclick="submit();">登録</button>
    </form>
    
    <!-- 
    メモ：先に!errors.isEmpty()で判定してしまうとヌルポになるので、初めにerrors != nul でnullかどうか確認してから
    　　　!errors.isEmpty()を実行するようにしている。
     -->
    <% if (errors != null && !errors.isEmpty()) { %>
    
        <% for (String error : errors) { %>
            <p><%= error %></p>
        <%} %>
        
    <%} %>
    
    <a href="/admin/articleManagement/articles">記事管理画面に戻る</a>
    </div>
    <%@ include file="/WEB-INF/jsp/admin/common/footer.jsp" %>
</body>
</html>