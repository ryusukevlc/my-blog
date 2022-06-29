<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/jsp/admin/common/head.jsp"%>
<body>
	<%@ include file="/WEB-INF/jsp/admin/common/header.jsp"%>

	<div class="grid-container">
		<form action="/admin/login" method="POST">
			<input type="text" placeholder="username"> <input type="text"
				placeholder="password">
			<button class="button" type="button" onclick="submit();">login</button>
		</form>
	</div>

	<%@ include file="/WEB-INF/jsp/admin/common/footer.jsp"%>
</body>
<style>
.grid-container {
	margin: 40px auto;
}
</style>
<script type="text/javascript">
	
</script>
</html>