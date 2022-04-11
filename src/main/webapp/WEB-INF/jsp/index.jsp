<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList" %> 
<%@ page import="model.article.Article" %>
<%@ page import="java.util.List" %>

<%
ArrayList<Article> articles = (ArrayList<Article>) request.getAttribute("articles");
List<String> titles = (List<String>)request.getAttribute("titles");
%>   

<!DOCTYPE html>
<html>
  <%@ include file="/WEB-INF/jsp/viewerCommon/head.jsp" %>
<body>
    <%@ include file="/WEB-INF/jsp/viewerCommon/header.jsp" %>
    
    <!-- 取得した記事を表示する -->
     <% if (articles != null && articles.size() > 0) { %>
     <div class="grid-container">
     <div class="grid-x grid-margin-x small-up-3 ">
    <% for(int i = 0 ; articles.size() > i ; i++) { %>
        <a href="/Morgenrot/articleDetail?id=<%= articles.get(i).getId() %>" class="cell">
            <div class="card" style="height: 380px;">
                <img alt="dummy" src="http://placekitten.com/g/640/340">
                <div class="card-divider" style="background-color: white;">
                    <object><a href="#" style="color: white;">tags（仮）</a></object><!-- あとで実装する -->
                </div>
                <div class="card-section" style="position: relative;">
                    <h5 style='font-family: "游ゴシック", "Yu Gothic";'><strong><%= titles.get(i)  %></strong></h5>
                    <small style="position:absolute; bottom: 20px;"><%= articles.get(i).getCreated_at() %></small>
                </div>
            </div>
        </a>
    <%} %>
     </div>
     </div>
    <%} else { %>
        <div>
            <p>まだ記事が投稿されていません。</p>
        </div>
    <%} %>
        <%@ include file="/WEB-INF/jsp/viewerCommon/footer.jsp" %>
</body>
</html>