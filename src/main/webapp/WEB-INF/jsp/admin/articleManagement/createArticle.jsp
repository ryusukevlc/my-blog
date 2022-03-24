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
    <h1>記事作成</h1>
    
    <form action="/Morgenrot/admin/articles" method="post">
        <input type="text" name="title">
        <input type="text" name="content">
        <input type="hidden" name="type" value="create">
        <input type="submit" value="登録">
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
    
    <a href="/Morgenrot/admin/articles">記事管理画面に戻る</a>
    <%@ include file="/WEB-INF/jsp/admin/common/footer.jsp" %>
</body>
</html>