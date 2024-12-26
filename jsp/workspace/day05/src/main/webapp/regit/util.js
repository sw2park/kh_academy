/**
 * 
 */
// 회원가입 폼 validation 처리
function sendit(){
	// 선언
	let idTag = document.getElementById("userid");
	let pwTag = document.getElementById("userpw");
	let nameTag = document.getElementById("username");
	let phoneTag = document.getElementById("userphone");
	
	// 아이디 "" 값 처리
	if(idTag.value == ""){
		alert("아이디를 입력하세요!");
		idTag.focus();
		return false;
	}
	// 비밀번호 "" 값 처리
	if(pwTag.value == ""){
		alert("패스워드를 입력하세요!");
		pwTag.focus();
		return false;
	}
	// 비밀번호 자리수 체크, 8자리 이상 체크
	if(pwTag.value.length < 8){
		alert("패스워드는 8자리 이상으로 입력하세요!");
		pwTag.focus();
		return false;
	}
	// 이름 "" 값 처리
	if(nameTag.value == ""){
		alert("이름을 입력하세요!");
		nameTag.focus();
		return false;
	}
	// 핸드폰 번호 "" 값 처리
	if(phoneTag.value == ""){
		alert("휴대폰 번호를 입력하세요!");
		phoneTag.focus();
		return false;
	}
	// submit()
	document.getElementById("joinForm").submit();
}