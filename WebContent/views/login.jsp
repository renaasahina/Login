<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!--外部スタイルシートの設定-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
<meta charset="UTF-8">

<title>ログイン画面</title>
</head>
<body>

<h1>ログイン</h1>
<!--formタグの設定-->
<form action="/Login/LoginServlet" method="post">

<p>${loginBean.getEmsg()}</p>
<div class="form">
<p>ユーザ名</p>
<input type="text" name="username" >


<p>パスワード</p>

<input type="password" name="password" >

<p><button type="submit" class="button">ログイン</button></p>
</div>
</form>
</body>
</html>