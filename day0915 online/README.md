# WebArchitecture

img 삽입

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

img 삽입

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

# JSP(Java Server Page)

# JSP Scriptlet

# JSP Directive

# JSP 기본객체
