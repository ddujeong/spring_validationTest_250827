<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h2>회원가입</h2>
	<form action="memberJoinOk">
	<hr>
	아이디 : <input type="text" name="id"><br><br>
	비밀번호 : <input type="password" name="password"><br><br>
	비밀번호 확인 : <input type="text" name="confirmPassword"><br><br>
	이름 : <input type="text" name="name"><br><br>
	이메일 : <input type="text" name="email"><br><br>
	나이 : <input type="text" name="age"><br><br>
	<input type="submit" value="회원가입">
	</form>
	<hr>
	<c:if test="${not empty signupError }">
		<span style="color: red;">${signupError }</span><br>
		<ul>
		<c:forEach items="${errorMsg }" var="errorM">
				<li>${errorM }</li>
		</c:forEach>
		</ul>
	</c:if>
</body>
</html>