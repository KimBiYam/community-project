<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="/resources/css/default.css" />
<link rel="stylesheet" href="/resources/css/style.css" />
<title>Insert title here</title>
</head>
<body>
	<form action="/member/login" method="post">
	<input type ="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
	<section class="login">
      <h2>로그인</h2>
      <ul>
        <li>
          <input id="id" name="username" type="text" placeholder="아이디" title="아이디입력" />
        </li>
        <li>
          <input id="password" name="password" type="password" placeholder="비밀번호" title="비밀번호입력" />
        </li>
        <li>
          <input type="checkbox" name="remember-me" id="chk_id" /><label for="chk_id">아이디저장</label>
        </li>
        <li><button id="loginBtn">로그인</button></li>
      </ul>
      <div>
        <ul>
          <li><a href="#">회원가입</a></li>
          <li><a href="#">아이디 찾기</a></li>
          <li><a href="#">비밀번호 찾기</a></li>
        </ul>
      </div>
    </section>
    </form>
    <script
	  src="https://code.jquery.com/jquery-3.5.1.js"
	  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	  crossorigin="anonymous"></script>
     <script>
      const loginBtn = document.getElementById("loginBtn");
      loginBtn.onclick = function () {
        if ($("#id").val() === "") {
          alert("아이디를 입력하세요!");
          $("#id").focus();
          return false;
        }
        if ($("#password").val() === "") {
          alert("패스워드를 입력하세요!");
          $("#password").focus();
          return false;
        }
        $("form").submit();
        
        
      };
    </script>
</body>
</html>