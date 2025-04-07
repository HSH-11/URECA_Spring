<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-4">
  <h1 class="text-center">회원가입</h1>
  
  <form id="registerForm" novalidate>
    <div class="mb-3">
      <label class="form-label">User ID:</label>
      <input type="text" class="form-control" id="userid" required placeholder="아이디 입력 (영문/숫자 4자 이상)">
      <div class="valid-feedback">사용 가능한 아이디입니다.</div>
      <div class="invalid-feedback">아이디는 4자 이상, 영문 또는 숫자 조합이어야 합니다.</div>
    </div>

    <div class="mb-3">
      <label class="form-label">Password:</label>
      <input type="password" class="form-control" id="password" required placeholder="비밀번호 입력">
      <div class="valid-feedback">안전한 비밀번호입니다.</div>
      <div class="invalid-feedback">영문, 숫자, 특수문자를 포함해야 합니다.</div>
    </div>

    <div class="mb-3">
      <label class="form-label">Name:</label>
      <input type="text" class="form-control" id="name" required placeholder="이름 입력 (2자 이상)">
      <div class="valid-feedback">이름이 유효합니다.</div>
      <div class="invalid-feedback">이름은 2자 이상이어야 합니다.</div>
    </div>

    <div class="mb-3">
      <label class="form-label">Email:</label>
      <input type="email" class="form-control" id="email" required placeholder="이메일 입력">
      <div class="valid-feedback">이메일 형식이 유효합니다.</div>
      <div class="invalid-feedback">이메일 형식이 올바르지 않습니다.</div>
    </div>

    <div class="mb-3">
      <label class="form-label">Phone:</label>
      <input type="text" class="form-control" id="phone" placeholder="입력 형태(010-1234-5678)">
      <div class="valid-feedback">전화번호 형식이 유효합니다.</div>
      <div class="invalid-feedback">전화번호 형식이 올바르지 않습니다.</div>
    </div>

    <div class="mb-3">
      <label class="form-label">Address:</label>
      <input type="text" class="form-control" id="address" placeholder="주소 입력">
      <div class="valid-feedback">주소가 유효합니다.</div>
      <div class="invalid-feedback">주소는 최소 5자 이상이어야 합니다.</div>
    </div>
  </form>

  <div class="d-grid gap-2">
    <button type="button" id="btnRegister" class="btn btn-primary">회원가입</button>
  </div>
</div>

<script>
window.onload = function () {
	  const form = document.querySelector("form");

	  // 버튼 클릭 시 유효성 전부 통과 확인
	  document.querySelector("#btnRegister").onclick = function () {
	    const invalids = form.querySelectorAll(".is-invalid");
	    if (invalids.length > 0) {
	      alert("입력값을 다시 확인해주세요.");
	      return;
	    }
	    register(); // 등록 함수 호출
	  };

	  // 각 입력 필드에 유효성 검사 이벤트 바인딩
	  document.querySelector("#userid").onblur = function () {
	    checkValidation(this, validateUserid);
	  };
	  document.querySelector("#password").onblur = function () {
	    checkValidation(this, validatePassword);
	  };
	  document.querySelector("#name").onblur = function () {
	    checkValidation(this, validateName);
	  };
	  document.querySelector("#email").onblur = function () {
	    checkValidation(this, validateEmail);
	  };
	  document.querySelector("#phone").onblur = function () {
	    checkValidation(this, validatePhone, false); // 선택 입력
	  };
	  document.querySelector("#address").onblur = function () {
	    checkValidation(this, validateAddress, false); // 선택 입력
	  };
	};

	// 유효성 검사 함수 (기본값은 필수 입력)
	function checkValidation(input, validatorFn, required = true) {
	  if (!required && input.value.trim() === "") {
	    input.classList.remove("is-invalid", "is-valid");
	    return;
	  }
	  if (validatorFn(input.value)) {
	    input.classList.add("is-valid");
	    input.classList.remove("is-invalid");
	  } else {
	    input.classList.add("is-invalid");
	    input.classList.remove("is-valid");
	  }
	}

	// 유효성 검사 규칙들
	function validateUserid(v) {
	  return /^[a-zA-Z0-9]{4,}$/.test(v); // 4자 이상, 영문/숫자
	}
	function validatePassword(v) {
	  return /[a-zA-Z]/.test(v) && /[0-9]/.test(v) && /[~!@#$%^&*]/.test(v);
	}
	function validateName(v) {
	  return v.trim().length >= 2;
	}
	function validateEmail(v) {
	  return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(v);
	}
	function validatePhone(v) {
	  return /^01[016789]-\d{3,4}-\d{4}$/.test(v);
	}
	function validateAddress(v) {
	  return v.trim().length >= 5;
	}

	// 회원가입 요청
	async function register() {
	  const userid = document.querySelector("#userid").value;
	  const password = document.querySelector("#password").value;
	  const name = document.querySelector("#name").value;
	  const email = document.querySelector("#email").value;
	  const phone = document.querySelector("#phone").value;
	  const address = document.querySelector("#address").value;

	  const urlParams = new URLSearchParams({
	    userid,
	    password,
	    name,
	    email,
	    phone,
	    address
	  });

	  const res = await fetch("/register/add", {
	    method: "POST",
	    body: urlParams
	  });
	  const data = await res.json();

	  if (data.result === "success") {
	    alert("회원가입이 완료되었습니다!");
	    window.location.href = "/index.html";
	  } else {
	    alert("회원가입에 실패했습니다. 다시 시도해주세요.");
	  }
	}
	</script>
</body>
</html>
