<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인</title>
</head>
<body>
	<div class="container">

		<div class="mb-3 mt-3 d-flex justify-content-center ">
			<h1 class="display-4">야구장 응원석 성공</h1>
		</div>

		<div class="mb-3">
			<h2>로그인</h2>
		</div>

		<form novalidate>		
			
			<div class="mb-3">
				<label for="userEmail" class="form-label">Email:</label> <input
					type="email" class="form-control" id="userEmail" name="userEmail"
					placeholder="Enter Email">
			</div>		
			<div class="mb-3">
				<label for="userPassword" class="form-label">Password:</label> <input
					type="password" class="form-control" id="userPassword"
					name="userPassword" placeholder="Enter Password">
			</div>
			
		</form>
		<div>
			<button type="button" id="btnLogin" class="btn btn-info">로그인
				</button>
		</div>
	</div>
<script>
	window.onload = function(){
		// btnRegister 처리
		document.querySelector("#btnLogin").onclick = function(){
			// validation check
			if (document.querySelector("#userEmail").value.length == '' || document.querySelector("#userPassword").value.length == ''){
				alert("입력이 올바르지 않습니다.");
				return;
			}
			login();
		}
		
	
	}
	
	// 로그인
	async function login(){
	
		let userPassword = document.querySelector("#userPassword").value;
		let userEmail = document.querySelector("#userEmail").value;
		
		// x-www-form-urlencoded
		let urlParams = new URLSearchParams({
			userPassword: userPassword,
			userEmail: userEmail,
		});
		
		//fetch Options
		let fetchOptions = {
				method: "POST",
				body: urlParams
		}
		
		let response = await fetch("/auth/login",fetchOptions);
		let data = await response.json();
		
		if (data.result == "success"){
			window.location.href="/pages/board";
		}else{
			alert("이메일 또는 비밀번호가 올바르지 않습니다.");
		}
		
	}
</script>
</body>
</html>