## JSP 소개
### JSP(Java Server Page)
- 장점
  - 웹 페이지 작성이 쉬움
  - 웹 디자인 도구와 같이 사용할 수 있음
  - 비즈니스 로직과 프리젠테이션의 분리가 가능함
- 단점
  - 디버깅이 어려움

## JSP 페이지 구성 요소
1. Fixed template data -html
2. Element(요소)
   - Directive Element(지시어원소)
   - Scripting Element(스크립팅 원소) 
     - 선언(Declaration)
     - 식(Expression)
     - 스크립트렛(scriptlet)
     - 식언어(EL: Expression Language)
   - Action Element(액션 원소, jsp 태그)

## Directive Element
- 웹 컨테이너(tomcat)에 특정한 정보를 전달하는 역할
- <%@ directive { 지시어 속성 } %>
- directive 종류: page, include, taglib

### Page 지시어
- <%@ page {지시어 속성} %>
- jsp페이지와 관련된 속성(정보)을 정의하고 이 속성들을 웹 컨테이너에 전달하는 지시어
- 웹 컨테이너가 jsp를 서블릿으로 변환할 때 이 정보들을 참조함

## Scripting Element
### 1. 선언(Declaration)
- jsp의 멤버필드나 메소드 선언 시 사용
  ```jsp
  <%
  int a = 7;
  public String go(){
    return "gogo";
  }
  %>
  ```

### 2. 식(Expression)
- 변수 값, 계산 결과, 함수 호출 결과를 직접 출력
- 문장 끝에 ;를 붙이지 않음
  ```jsp
  <%= a %>
  <%= go() %>
  ```

### 3. 스크립트렛(scriptlet)
- 자바코드 기술하는 영역
  ```jsp
  <%
    for(int i=0; i<10; i++){
      out.println("hello");
    }
  %>
  ```

## JSP 디폴트 객체
- 스크립팅 원소(스크립트렛, 식, 식 언어)에서 선언이나 생성하지 않고 바로 사용할 수 있는 객체

## Action Element
### JSP 액션(=JSP 태그)
- 표준화된 태그를 이용해서 객체의 생성 및 접근을 지원함
- 제어를 다른 페이지로 이동시킴
- 현재의 페이지 안에 다른 동적인 자원을 포함시킴

### jsp:forward 태그
- 제어를 다른 페이지로 이동시킴
- 형태 1
  ```jsp
  <jsp:forward page="relativeURLspec"/>
  ```
- 형태2
  ```jsp
  <jsp:forward page="urlSpec">
    {<jsp:param ... />}*
  </jsp:forward>
  ```

### include 태그
- 현재의 jsp페이지에 동적으로 다른 자원을 포함시킴
- 지시어 include : 복붙한 상태와 비슷, 정적인 include 
  ```jsp
  <%@ include file="in.jsp" %>
  ```
- action incude : 수정이 자주 일어나는 경우 사용하면 좋다, 동적인 include
  ```jsp
  <jsp:include page="in.jsp"/>
  ```

