<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/resources/css/default.css">
    <title>회원가입</title>
  </head>
  <body>
    <div class="join">
    <form action="/member/join" method="post">
    <input type ="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	      <h2>회원 가입</h2>
	      <div class="con">
	      <table class="type1">
	        <caption>
	          <details class="hidden">
	            <summary>
	              회원가입 폼
	            </summary>
	            <div>
	              신청자이름, 연락처, 메모, 적용 가능한 혜택을 입력 또는 선택하는 표
	            </div>
	          </details>
	        </caption>
	        <colgroup>
	          <col style="width: 111px;" />
	        </colgroup>
	        <tbody>
	          <tr>
	            <th><label for="id">아이디</label>
	              <span>*<em class="hide">필수입력</em></span></th>
	            <td><input type="text" id="id" name="id" placeholder="아이디를 입력해 주세요." /></td>
	          </tr>
           	  <tr>
	            <th><label for="password">패스워드</label>
	              <span>*<em class="hide">필수입력</em></span></th>
	            <td><input type="password" id="password" name="password" placeholder="패스워드를 입력해 주세요." /></td>
	          </tr>
          	  <tr>
	            <th><label for="password">패스워드 확인</label>
	              <span>*<em class="hide">필수입력</em></span></th>
	            <td><input type="password" id="pwdCheck" placeholder="패스워드를 입력해 주세요." /></td>
	          </tr>
	          <tr>
	            <th><label for="name">이름</label><span>*<em class="hide">필수입력</em></span></th>
	            <td><input type="text" id="name" name="name" placeholder="이름을 입력해 주세요" /></td>
	          </tr>
	        </tbody>
	      </table>
			</div>
	    <div class="txt_center">
	  	  <button type="button" id="joinBtn" class="btn_type1">회원가입</button>
		</div>
	</form>
   </div>
  <script
  src="https://code.jquery.com/jquery-3.5.1.js"
  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous"></script>
  <script>
  	$("#joinBtn").on("click",function(){
  	  	if($("#id").val()===""){
  	  	  	alert("아이디를 입력해 주세요");
  	  	  	$("#id").focus();
  	  	  	return false;
  	  	  	}
  	  	if($("#password").val()===""){
  	  	  	alert("패스워드를 입력해 주세요");
  	  	  	$("#password").focus();
  	  	  	return false;
  	  	  	}
  	  	if($("#password").val() != $("#pwdCheck").val()){
  	  	  	alert("패스워드를 확인해 주세요");
  	  	  	$("#password").focus();
  	  	  	return false;
  	  	  	}
  	  	if($("#name").val()===""){
  	  	  	alert("이름을 입력해 주세요");
  	  	  	$("#name").focus();
  	  	  	return false;
  	  	  	}
  	  	$("form").submit();
  	  	})
  	
  </script>
  
  </body>
</html>