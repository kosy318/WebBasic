# AJAX 소개
- Asynchrnous JavaScript and XML는 언어나 프레임워크가 아닌 구현하는 방식을 의미
- Ajax는 웹에서 화면을 갱신하지 않고 데이터를 서버로부터 가져와 처리하는 방법을 의미
- JavaScript의 XMLHttpRequest(XHR) 객체로 데이터를 전달하고 비동기 방식으로 결과를 조회
- 화면 갱신이 없으므로 사용자 입장에서는 편리하지만, 동적으로 DOM을 구성해야 하므로 구현이 복잡
	- 일반 요청에 대한 응답
		- data를 입력 후 event 발생
		- Ajax를 적용하지 않은 요청은 서버에서 data를 이용하여 logic 처리
		- logic 처리에 대한 결과에 따라 응답 page를 생성하고 client에 전송(화면 전환이 일어남)
	- AJAX 요청에 대한 응답
		- data를 입력 후 event 발생
		- Ajax를 적용하면 event 발생시 서버에서 요청을 처리한 후 Text, XML 또는 JSON으로 응답
		- client(Browser)에서는 이 응답 data를 이용하여 화면 전환없이 현재 페이지에서 동적으로 화면을 재구성(DOM)

## 서버와 클라이언트의 상호작용
- SSR(Server side rendering), CSR(Client side rendering)
- 웹 화면을 구성하는 방식은 서버 중심의 상호작용 방식과 클라이언트 중심의 상호작용 방식으로 구분
- 서버 중심의 개발방식은 화면 구성이 서버에서 이루어진다.(프리젠테이션 영역의 JSP나 PHP, ASP 등)
- 클라이언트 중심의 개발방식은 클라이언트(웹 브라우저)에서 화면을 구성한다.(주로 JavaScript)
- Ajax는 클라이언트 중심의 개발 방식이며 비동기 요청보다는 동적 화면구성이 관건임.

## AJAX 사용방식
### XMLHttpRequest(서버와 통신을 위한 객체) 이용 방식(Browser)
```javascript
var ajax = new XMLHttpRequest();
ajax.onreadystatechange = function(){ // 준비상태가 바뀌게 되면 호출되는 callback
	if(this.readyState == 4){ // 모든 데이터가 client한테 도착했다
		if(this.status == 200){ // 정상적 동작했을 때
			console.log(ajax.responseText);
			console.log(ajax.responseXML);
		}
	}
};
ajax.open("GET/POST", "호출 URL", true); // true : 비동기
ajax.send(); // 서버에 데이터 넘김
```

### fetch() 이용방식(Browser)
```javascript
fetch("URL 링크")
	.then((response) => {
		if(!response.ok){
			throw new Error("400 또는 500 에러 발생!!!");
		}
		return response.json(); // 아래 result한테 전달됨
	})
	.then((result) => {
		console.log(result);
	})
	.catch(() => {
		console.log("에러 발생!!!");
	});
```

### 외부라이브러리 이용 방식 - jQuery.
```javascript
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$(function (){
		$.ajax({
			type: "GET/POST",
			url: "호출 URL",
			dataType: "xml/json",
			success: function(result){
				// TODO Action
			},
		});
	});
</script>
```

### 외부라이브러리 이용 방식 - axios
```javascript
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script>
	axios
		.get("호출 URL")
		.then((result) => {
			console.log(result.data);
		})
		.catch(() => {
			console.log("에러 발생!!!");
		});
</script>
```

## GET 방식과 POST 방식
### GET 방식의 특직
- URL에 변수(데이터)를 포함시켜 요청한다.
- 데이터를 Header(헤더)에 포함하여 전송한다.
- URL에 데이터가 노출되어 보안에 취약하다.
- 전송하는 길이에 제한이 있다.
- 캐싱할 수 있다.
	- 캐싱이란 한번 접근 후, 또 요청할 시 빠르게 접근하기 위해 레지스터에 데이터를 저장시켜 놓는 것

### POST 방식의 특징
- URL에 변수(데이터)를 노출하지 않고 요청한다.
- 데이터를 Body(바디)에 포함시킨다.
- URL에 데이터가 노출되지 않아서 기본 보안은 되어있다.
- 전송하는 길이에 제한이 없다.
- 캐싱할 수 없다.

# XMLHttpRequest
<b>ajaxTest</b><br>
- Dynamic Web Project로 생성
- perspective JavaEE로 바꾸기
- 우클릭 -> configure -> convert to maven(내부적으로 필요한 jar 파일들을 알아서 다운 받아줌)

## Javascript AJAX
- XMLHttpRequest는 자바스크립트가 Ajax 방식으로 통신할 때 사용하는 객체
- XMLHttpRequest 객체는 Ajax 통신 시 전송방식, 경로, 서버로 전송할 data등 전송정보를 담는 역할
- 실제 서버와의 통신은 브라우저의 Ajax 엔진에서 수행
- 직접 자바스크립트로 Ajax를 프로그래밍할 경우 브라우저 별로 통신 방식이 달라 코드가 복잡해진다.

```javascript
<script type="text/javascript">
var httpRequest = null;

function getXMLHttpRequest(){
	if(window.ActiveXObject){ // MS IE
		try{
			return new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e1){
			try{
				return new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e2){
				return null;
			}
		}
	}else if(window.XMLHttpRequest){ // 기타 웹 브라우저
		return new XMLHttpRequest();
	}else{
		return null;
	}
}

function sendRequest(url, params, callback, method){
	httpRequest = getXMLHttpRequest();
	
	// default 는 GET
	var httpMethod = method ? method : 'GET';
	if(httpMethod != 'GET' && httpMethod != 'POST'){
		httpMethod = 'GET';
	}
	
	var httpParams = (params == null || params == '') ? null : params;
	var httpUrl = url;
	if(httpMethod == 'GET' && httpParams != null){
		httpUrl = httpUrl + "?" + httpParams;
	}
	
	// open() : 요청의 초기화, GET/POST 선택, 접속할 URL 입력
	httpRequest.open(httpMethod, httpUrl, true); // 서버와 연결
	httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	httpRequest.onreadystatechange = callback; // callback 함수 등록
	// send() : web server에 요청 전송.
	httpRequest.send(httpMethod == 'POST' ? httpParams : null);
}
</script>
```

## Javascript AJAX 적용 예
> SSR<br>

- Server의 시간을 출력하는 예제(AJAX 미사용)
	- <b>ajaxTest/2-02.html</b><br>
	- <b>ajaxTest/2-02currenttime.jsp</b><br>
- Server의 시간을 출력하는 예제(AJAX 미사용)
	- <b>ajaxTest/2-03.html</b><br>
	- <b>ajaxTest/2-03currenttime.jsp</b><br>

### httpRequest의 속성값
- readyState

|값|의미|설명|
|:-:|---|---|
|0|Uninitialized|객체만 생성(open 메소드 호출 전)|
|1|Loading|open 메소드 호출|
|2|Loaded| send 메소드 호출. status의 헤더가 아직 도착되기 전 상태|
|3|Interactive|데이터 일부를 받은 상태|
|4|Completed|데이터 전부를 받은 상태|

- status

|  값  | 텍스트(status Text)     | 설명  |
|:---:|-----------------------|---|
| 200 | OK                    | 요청 성공  |
| 403 | Forbidden             | 접근 거부  |
| 404 | Not Found             | 페이지 없음  |
| 500 | Internal Server Error | 서버 오류 발생  |

# fetch()
# CSV, XML, JSON
# Google Map API
# Kakao Map API
