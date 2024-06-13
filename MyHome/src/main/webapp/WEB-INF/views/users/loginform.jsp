<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Home: Login</title>
<link rel="stylesheet" href="css/users2.css">

<style>
	.button-container .submit-button {
		background-color: #4CAF50;
		border: none;
		color: white;
		padding: 15px 32px;
		text-align: center;
		text-decoration: none;
		display: inline-block;
		font-size: 16px;
		margin: 4px 2px;
		cursor: pointer;
	}
</style>

</head>
<body>
	<h1>Login</h1>
	<form method="POST" action="">
		<input type="hidden" name="a" value="login" />
		<label for="email">이메일</label>
		<input type="text" name="email" /><br>
		<label for="password">Password</label>
		<input type="password" name="password" /><br/>
		<input type="submit" value="전송" />
	</form>


    <div class="button-container">
        <form method="GET" action="">
			<input type="hidden" name="a" value="joinform">
            <input type="submit" value="가입하기" class="submit-button" />
        </form>
    </div>




</html>
</body>
</html>
