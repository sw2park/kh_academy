/**
 * 
 */
// 회원가입 폼 value 확인하는 자바스크립트
function sendit(){
	let frm = document.joinForm;
	let userid = frm.userid;
	let userpw = frm.userpw;
	let userpw_re = frm.userpw_re;
	let username = frm.username;
	let userphone = frm.userphone;
	
	// 아이디 빈값 처리
	if(userid.value==""){
		alert("아이디를 입력하세요.");
		userid.focus();
		return false;
	}
	
	// 아아디는 5자리 이상, 16자리 미만
	if(userid.value.length <=4 || userid.value.length >= 16){
		alert("아이디는 5자리 이상, 16자 미만으로 작성해주세요.");
		userid.focus();
		return false;
	}
	
	// 비밀번호 빈 값처리
	if(userpw.value==""){
		alert("비밀번호를 입력하세요.");
		userpw.focus();
		return false;
	}
	
	// 비밀번호 8자리 이상 처리
	if(userpw.value.length<8){
		alert("패스워드는 8자 이상으로 입력하세요.");
		userpw.focus();
		return false;
	}
	// 비밀번호 == 비밀번호 확인 처리
	if(userpw.value != userpw_re.value){
		alert("패스워드 확인을 다시하세요.")
		userpw_re.focus();
		return false;
	}
	// 이름 빈값 처리
	if(username.value==""){
		alert("이름을 입력하세요.");
		username.focus();
		return false;
	} 
	// 휴대폰 번호 빈값처리
	if(userphone.value==""){
		alert("휴대폰 번호를 입력하세요.");
		userphone.focus();
		return false;
	}
	
	frm.submit();
}

function login(){
	let frm = document.frm;
	let userid = frm.userid;
	let userpw = frm.userpw;
	// 아이디 빈 값체크
	if(userid.value == ""){
		alert("아이디를 입력해주세요.");
		console.log(userid.value);
		userid.focus();
		return false;
	}
	// 비밀번호 빈 값 체크
	if(userpw.value == ""){
		console.log(userpw.value);
		alert("비밀번호를 입력해주세요.");
		userpw.focus();
		return false;
	}
	frm.submit();
}

function checkId(){
	let userid = document.getElementById("userid").value;
	
	if(userid == ""){
		alert("아이디를 입력해주세요.");
		//userid.focus();
		return false;
	} else {
		// ajax 통신으로 id 중복체크
		// get, idcheck.jsp?userid=userid
		// id가 text인<p>태그에 "ok"이면 -> 사용할 수 있는 아이디입니다.
		// "not-ok"이면 -> 중복된 아이디입니다.
		let xhr = new XMLHttpRequest();
		xhr.open("GET", "idcheck.jsp?userid="+userid, true);
		xhr.send();
		xhr.onreadystatechange = function(){
			if(xhr.status == 200 && xhr.readyState == XMLHttpRequest.DONE){
				// alert(xhr.responseText);
				if(xhr.responseText.trim() == "ok"){
					document.getElementById("text").innerHTML = "사용할 수 있는 아이디입니다.";
				} else {
					document.getElementById("text").innerHTML = "중복된 아이디 입니다.";
				}
			}
		}
	}
}