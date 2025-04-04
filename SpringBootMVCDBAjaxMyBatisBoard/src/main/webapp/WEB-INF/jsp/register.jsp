<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<title>회원 가입</title>
</head>
<body>
	<!-- validation check
	브라우저 내장 유효성 검사 X <= <form 
	Bootstrap 제공 유효성 검사 O
 -->
	<div class="container">

		<div class="mb-3 mt-3 d-flex justify-content-center ">
			<h1 class="display-4">야구장 응원석 성공</h1>
		</div>

		<div class="mb-3">
			<h2>회원 가입</h2>
		</div>

		<form novalidate>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">User
					Name:</label> <input type="text" class="form-control" id="userName"
					name="userName" placeholder="Enter User Name">
					<div class="valid-feedback">Valid</div>
					<div class="invalid-feedback">User Name은 2글자 이상입니다.</div>
			</div>
			<div class="mb-3">
				<label for="userPassword" class="form-label">Password:</label> <input
					type="password" class="form-control" id="userPassword"
					name="userPassword" placeholder="Enter Password">
					<div class="valid-feedback">Valid</div>
					<div class="invalid-feedback">Password는 적어도 1개 이상의 특수문자, 알파벳이 포함되어야 합니다</div>
			</div>
			<div class="mb-3">
				<label for="userPassword2" class="form-label">Password
					Confirm:</label> <input type="password" class="form-control"
					id="userPassword2" name="userPassword2"
					placeholder="Confirm Password">
					<div class="valid-feedback">Valid</div>
					<div class="invalid-feedback">Password를 다시 확인하세요</div>
			</div>
			<div class="mb-3">
				<label for="userEmail" class="form-label">Email:</label> <input
					type="email" class="form-control" id="userEmail" name="userEmail"
					placeholder="Enter Email">
					<div class="valid-feedback">Valid</div>
					<div class="invalid-feedback">Email 형식이 맞지 않습니다.</div>
			</div>
		</form>
		<div>
			<button type="button" id="btnRegister" class="btn btn-info">회원
				가입</button>
		</div>
	</div>
<script>
	window.onload = function(){
		// btnRegister 처리
		document.querySelector("#btnRegister").onclick = function(){
			// validation check
			if (document.querySelectorAll("form .is-invalid").value > 0){
				alert("입력이 올바르지 않습니다.");
				return;
			}
			register();
		}
		
		// focus를 잃을 때 <= 입력 완료 후 다른 입력으로 넘어갈 때
		document.querySelector("#userName").onblur = function(){
			if (validateUserName(this.value)){
				this.classList.remove("is-invalid"); //부트스트랩이 알아서 처리
				this.classList.add("invald");
			}else{
				this.classList.remove("is-valid");
				this.classList.add("is-invalid");
			}
		}
		
		document.querySelector("#userPassword").onblur = function(){
			if (validateUserPassword(this.value)){
				this.classList.remove("is-invalid"); //부트스트랩이 알아서 처리
				this.classList.add("invald");
			}else{
				this.classList.remove("is-valid");
				this.classList.add("is-invalid");
			}
		}
		document.querySelector("#userPassword2").onblur = function(){
			if (validateUserPassword2(this.value)){
				this.classList.remove("is-invalid"); //부트스트랩이 알아서 처리
				this.classList.add("invald");
			}else{
				this.classList.remove("is-valid");
				this.classList.add("is-invalid");
			}
		}
		document.querySelector("#userEmail").onblur = function(){
			if (validateUserEmail(this.value)){
				this.classList.remove("is-invalid"); //부트스트랩이 알아서 처리
				this.classList.add("invald");
			}else{
				this.classList.remove("is-valid");
				this.classList.add("is-invalid");
			}
		}
	}
	
	function validateUserName(userName){
		// 2글자 이상
		if ( userName.length >= 2) return true;
		return false;
	}
	function validateUserPassword(userPassword){
		
		 let patternEngAtListOne = new RegExp(/[a-zA-Z]+/);// 알파벶 적어도 1개 이상
		 let patternSpeAtListOne = new RegExp(/[~!@#$%^&*()_+|<>?:{}]+/);// 특수문자 적어도 1개이상
		 let patternNumAtListOne = new RegExp(/[0-9]+/);// 숫자 적어도 1개 이상
		 
		 if ( patternEngAtListOne.test(userPassword) &&
			  patternSpeAtListOne.test(userPassword) &&
			  patternNumAtListOne.test(userPassword)
		 ) return true;
		 return false;
	}
	function validateUserPassword2(userPassword2){
		// userPassword와 일치
		if ( userPassword2 == document.querySelector("#userPassword").value) return true;
		return false;
	}
	
	function validateUserEmail(userEmail){
		// . @
		let regexp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		if ( regexp.test(userEmail)) return true;
		return false;
	}
	
	async function register(){
		let userName = document.querySelector("#userName").value;
		let userPassword = document.querySelector("#userPassword").value;
		let userEmail = document.querySelector("#userEmail").value;
		
		// x-www-form-urlencoded
		let urlParams = new URLSearchParams({
			userName: userName, // 같은 경우 생략가능
			userPassword: userPassword,
			userEmail: userEmail,
		});
		
		//fetch Options
		let fetchOptions = {
				method: "POST",
				body: urlParams
		}
		
		let response = await fetch("/user/register",fetchOptions);
		let data = await response.json();
		
		if (data.result == "success"){
			alert("회원가입에 성공했습니다.");
			// 로그인 페이지 이동
			window.location.href="/pages/login";
		}else{
			alert("회원가입 도중 문제가 생겼습니다.");
		}
		
	}
</script>
</body>
</html>