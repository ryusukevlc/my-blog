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
    <%@ include file="/WEB-INF/jsp/admin/common/header.jsp" %>
    
<div class="grid-container">
<div class="grid-x grid-margin-x">
    
    <a class="button" href="/admin/articleManagement/articleCreate">作成</a>

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
                <tr class="">
                    <td><%= article.getTitle() %></td>
                    <td><%= article.getContent() %></td>
                    <td style="text-align:right; ">
                        <a class="small success button" href="/admin/articleManagement/articleEdit?id=<%= article.getId() %>">編集</a>
                    </td>
                   <td style="">
                    <form action="/admin/articleManagement/articles" method="post" name="deleteForm">
                        <input type="hidden" name="id" value="<%= article.getId() %>">
                        <input type="hidden" name="type" value="delete">
                        <button class="small alert button" onclick=" return articleDelete()">削除</button>
                    </form>
                   </td>
                </tr>
             <%} %>
             <%} else { %>
                <tr>
                    <td>まだ記事が投稿されていません。</td>
                </tr>
             <%} %>
        </tbody>
    </table>
    
    
    <a href="/admin/portal">ポータルへ戻る</a>
    
</div>
</div>
    
    <%@ include file="/WEB-INF/jsp/admin/common/footer.jsp" %>
</body>

<script type="text/javascript">

//記事を削除する時のダイアログ表示
function articleDelete() {
	var result = window.confirm("削除しますか？");
	
	if (result) {
		console.log('OKがクリックされました');
		return true;
	} else {
		console.log('キャンセルがクリックされました');
		return false;
	}
	
}
</script>

</html>