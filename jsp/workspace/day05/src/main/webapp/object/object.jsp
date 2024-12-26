<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>내장 객체 예제</h3>
	<form action="object_ok.jsp" name="joinForm">
		<fieldset>
			<legend>개인정보</legend>
			<input type="text" name="username">
			<input type="date" name="userbirth">
			<input type="button" value="확인" onclick="sendit()">
		</fieldset>
	</form>
	<script type="text/javascript">
		function sendit() {
			let joinForm = document.joinForm;
			let nameTag = joinForm.username;
			let birthTag = joinForm.userbirth;
			// 이름이 빈값이면, "이름을 입력하세요"
			if(nameTag.value == ""){
				alert("이름을 입력해주세요.");
				nameTag.focus();
				return false;
			}
			// 생일이 빈값이면, "생일 정보를 입력하세요."
			if(birthTag.value == ""){
				alert("생일 정보를 입력해주세요.");
				birthTag.focus();
				return false;
			}
			// 페이지 submit()
			joinForm.submit();
		}
	</script>
</body>
</html>