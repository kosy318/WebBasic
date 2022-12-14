# WebArchitecture

<img src="https://user-images.githubusercontent.com/77595685/191090110-4e7726df-9533-49b9-8656-2d312631e0c1.png" style="width:800px;">

### project 생성

1. New -> Dynamic Web Project 선택
2. project name 설정, target runtime 선택
3. context root와 content directory 확인(변경 가능)
   - Generate web.xml deployment descriptor : Dynamic Web module의 버전이 3.0미만일 경우 반드시 체크, 3.0이상일 경우 선택(일반적으로 체크x, annotation 사용)

- src 폴더 : web application에 필요한 java file 위치
- Apache Tomcat v9.0 [Apache Tomcat v9.0] : tomcat library(servlet-api.jar 위치)
- JRE System Library : jre library
- WebContent 폴더 : view directory; html, css, js, jsp, img, ...
- WebContent/WEB-INF/lib 폴더 : web application에 필요한 확장 library
- WebContent/WEB-INF/web.xml : web application의 설정 파일; web module 3.0이상부터는 annotation으로 대체 가능

# Servlet

New -> Servlet<br>
자바 서블릿(Java Servlet)은 자바를 사용하여 웹페이지를 동적으로 생성하는 서버측 프로그램 혹은 그 사양을 말하며, 흔히 "서블릿"이라 불린다. 자바 서블릿은 웹 서버의 성능을 향상하기 위해 사용되는 자바 클래스의 일종이다. 서블릿은 JSP와 비슷한 점이 있지만, JSP가 HTML 문서 안에 Java 코드를 포함하고 있는 반면, 서블릿은 자바 코드 안에 HTML을 포함하고 있다는 차이점이 있다.

- servlet : html in java
- jsp : java in html

# Servlet Life-Cycle

servlet class는 javaSE에서의 class와는 다르게 main method가 없다. 즉 객체의 생성부터 사용(method call)의 주체가 사용자가 아닌 Servlet Container(WAS)에게 있다.
Client가 요청(request)을 하게 되면 Servlet Container는 Servlet객체를 생성(한번만)하고, 초기화(init, 한번만)하며 요청에 대한 처리(요청시마다 반복)를 하게 된다. 또한 Servlet객체가 필요 없게 되면 제거(destroy())하는 일까지 Container가 담당하게 된다.

### Servlet Life-Cycle의 주요 method

<img src="https://user-images.githubusercontent.com/77595685/191090246-89d6c31a-a8b1-4772-b8f9-501a575c07c5.png" style="width:400px;">

<table>
<thead>
<tr>
<td>method</td>
<td>description</td>
</tr>
</thead>
<tbody>
<tr>
<td>init()</td>
<td>서블릿이 메모리에 로드 될 때 한번 호출.<br>코드 수정으로 인해 다시 로드 되면 다시 호출</td>
</tr>
<tr>
<td>doGet()</td>
<td>GET방식으로 data전송 시 호출.</td>
</tr>
<tr>
<td>doPost()</td>
<td>POST방식으로 data전송 시 호출.</td>
</tr>
<tr>
<td>service()</td>
<td>모든 요청은 service()를 통해서 doXXX()메소드로 이동.</td>
</tr>
<tr>
<td>destroy()</td>
<td>서블릿이 메모리에서 해제되면 호출<br>코드가 수정되면 호출</td>
</tr>
</tbody>
</table>

# Servlet Parameter 처리

<table>
<thead>
<tr>
<td></td>
<td>GET</td>
<td>POST</td>
</tr>
</thead>
<tbody>
<tr>
<td>특징</td>
<td>전송되는 데이터가 URL 뒤에 Query String으로 전달.<br>입력 값이 적은 경우나 데이터가 노출이 돼도 문제가 없을 경우 사용.</td>
<td>URL과 별도로 전송.<br>HTTP header 뒤 body에 입력 스트림 데이터로 전달.</td>
</tr>
<tr>
<td>장점</td>
<td>간단한 데이터를 빠르게 전송.<br>form tag뿐만 아니라 직접 URL에 입력하여 전송 가능.</td>
<td>데이터의 제한이 없다.<br>최소한의 보안 유지 효과를 볼 수 있다.</td>
</tr>
<tr>
<td>단점</td>
<td>데이터 양에 제한이 있다.<br>(location bar(URL+parameters)를 통해 전송할 수 있는 데이터의 사이즈는 2kb(2048byte)로 제한된다.</td>
<td>전달 데이터의 양이 같을 경우 GET방식보다 느리다.<br>전송 패킷을 body에 데이터를 구성해야 하므로)</td>
</tr>
</tbody>
</table>

<img src="https://user-images.githubusercontent.com/77595685/191090476-0d05a885-9229-443c-b607-ee5fc30e85a3.png" style="width:700px;">

# JSP(Java Server Page)

<a href=""><b>hellojsp</b></a>

자바 서버 페이지는 HTML 내에 자바 코드를 삽입하여 웹 서버에서 동적으로 웹페이지를 생성하여 웹브라우저에 돌려주는 언어입니다. Java EE 스펙 중 일부로 웹 애플리케이션 서버에서 동작한다. 자바 서버 페이지는 실행시에는 자바 서블릿으로 변환된 후 실행되므로 서블릿과 거의 유사하다고 볼 수 있다. 하지만 서블릿과 달리 HTML 표준에 다라 작성되므로 웹 디자인하기에 편하다. 이와 비슷한 구조로 PHP, ASP, ASP.NET등이 있다.<br>
아파치 스트럿츠나 자카르타 프로젝트의 JSTL 등의 JSP 태그 라이브러리를 사용하는 경우에는 자바 코딩없이 태그만으로 간략히 기술이 가능하므로 생산성을 높일 수 있다.
<br>
compile 기반 언어의 특징(속도가 빠름) + Interpreter 언어의 특징(코딩하기에 편리)

<img src="https://user-images.githubusercontent.com/77595685/191690228-737f290b-80c1-4233-8ea2-6e034b674029.png" style="width:1000px;"/>

# JSP Scriptlet

## JSP 스크립팅 요소(Scripting Element)

### 선언(Declaration)

멤버 변수 선언이나 메쇄드를 선언하는 영역

```jsp
<%! 멤버 변수 선언과 method 작성 %>
```

### 스크립트릿(Scriptlet)

Client 요청 시 매번 호출 영역으로, Servlet으로 변호나 시 service() method에 해당되는 영역. request, response에 관련된 코대ㅡ 구현.

```jsp
<% java code %>
```

### 표현식(Expression)

데이터를 브라우저에 출력할 때 사용<br>
주의) 문자열 뒤 세미콜론은 작석x

```jsp
<%= 문자열 %>
```

### 주석(Comment)

코드 상에서 부가 설명을 작성

```jsp
<%-- 주석할 code --%>
```

# JSP Directive

<a href=""><b>board2_jsp</b></a>

# JSP 기본객체

## 추가 정리 필요!!!!
