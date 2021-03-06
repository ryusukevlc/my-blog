<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList" %> 
<%@ page import="model.article.Article" %>
<%@ page import="java.util.List" %>

<!-- テストコメント develop -->
<!-- テストコメント pull request practice -->

<%
ArrayList<Article> articles = (ArrayList<Article>) request.getAttribute("articles");
List<String> titles = (List<String>)request.getAttribute("titles");
int weather = (int)request.getAttribute("weather");
%>   

<!DOCTYPE html>
<html>
  <%@ include file="/WEB-INF/jsp/viewerCommon/head.jsp" %>
<body>
    <jsp:include page="/WEB-INF/jsp/viewerCommon/header.jsp">
          <jsp:param name="weather" value="<%=weather %>" />
    </jsp:include>
    
    <!-- 取得した記事を表示する -->
     <% if (articles != null && articles.size() > 0) { %>
     <div class="grid-container">
     <div class="grid-x grid-margin-x small-up-3 ">
    <% for(int i = 0 ; articles.size() > i ; i++) { %>
        <a href="/articleDetail?id=<%= articles.get(i).getId() %>" class="cell">
            <div class="card" style="height: 340px;">
                <img alt="dummy" src="http://placekitten.com/g/640/340">
                <div class="card-divider" style="background-color: white; height: 20px;">
                    <object style=" position: relative; top: -10px;"><a href="#" class="tag">tags（仮）</a></object><!-- あとで実装する -->
                </div>
                <div class="card-section" style="position: relative;">
                    <h5 style='font-family: "游ゴシック", "Yu Gothic"; font-size: 15px; position: relative; top: -10px;'><strong><%= titles.get(i)  %></strong></h5>
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
<style>
.cell {

}
</style>
</html>