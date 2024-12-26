/**
 * 
 */
// ajax get
function send1(){
	let xhr = new XMLHttpRequest();
	// open(전달방식, URL 주소, 동기여부(true:비동기, false:동기));
	xhr.open("GET", "request_ajax.jsp?userid=apple&userpw=abcd1234", true);
	// 작성된 ajax 요청을 서버로 전달
	xhr.send();
	xhr.onreadystatechange = function(){
		// 통신이 성공했을 경우
		// XMLHttpRequest.DONE : 요청한 데이터의 처리가 완료되어 응답할 준비가 완료됨
		if(xhr.status == 200 && xhr.readyState == XMLHttpRequest.DONE){
			document.getElementById("result").innerHTML = xhr.responseText;
			//alert(xhr.responseText);
		}
	}
}

// ajax post
function send2(){
	let xhr = new XMLHttpRequest();
	xhr.open("POST", "request_ajax.jsp?", true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.send("userid=admin&userpw=admin1234");
	xhr.onreadystatechange = function(){
		if(xhr.status == 200 && xhr.readyState == XMLHttpRequest.DONE){
			document.getElementById("result").innerHTML = xhr.responseText;
		}
	}
}

function json(){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", "data.json", true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.status == 200 && xhr.readyState == XMLHttpRequest.DONE){
			// alert(xhr.responseText);
			let obj = JSON.parse(xhr.responseText);
			alert(obj.count);
			alert(obj.result);
		}
	}
}

function realtime(){
	let obj = "";
	let word = new Array();
	let xhr = new XMLHttpRequest();
	xhr.open("GET", "data2.json", true);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.status == 200 && xhr.readyState == XMLHttpRequest.DONE){
			 // alert(JSON.parse(xhr.responseText));
			 obj = JSON.parse(xhr.responseText);
			 // 파싱된 obj에서 search_word라는 key를 가지고 있는 것을 꺼내보면 [{},{},{},{},{}]
			 // 즉, 배열이다.
			 
			 for(let i=0; i<obj.search_word.length; i++){
				// 각방의 json들에서 name 키로 담겨있는 검색어를 꺼내서 word 배열의 각 방에 넣는다.
				word[i] = obj.search_word[i].name;			
			 }
		}
	}
	let i = 0;
	let interval = setInterval(function(){
		i = i % obj.search_word.length;
		document.getElementById("td1").innerHTML = i+1;
		document.getElementById("td2").innerHTML = word[i];
		i++;
	}, 2000);
	
	// setTimeout(함수, 밀리초) : 해당 밀리초 이후에 앞에 넘겨준 함수 호출
	setTimeout(function(){
		// clearInterval(인터벌) = 해당 인터벌 삭제
		clearInterval(interval);
	}, 20000); // 20초후
}