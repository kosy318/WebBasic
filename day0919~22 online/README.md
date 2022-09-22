# Web Application Architecture - MVC

-   JSP를 이용하는 구성할 수 있는 Web Application Architecture는 크게 model1과 model2로 나뉜다.
-   JSP가 client의 요청에 대한 Logic 처리와 response page(view)에 대한 처리를 모두 하느냐, 아니면 response page(view)에 대한 처리만 하는지가 가장 큰 차이점이다.
-   Model2구조는 MVC(Model-View-Controller) Pattern을 Web 개발에 도입한 구조를 말한다.

## Model1

### Model1 구조

-   model1은 view와 logic을 JSP 페이지 하나에서 처리하는 구조를 말한다.
-   client로부터 요청이 들어오게 되면 JSP 페이지는 java beans나 별도의 service class를 이용하여 작업을 처리, 결과를 client에 출력한다.

img 삽입

### Model1 구조의 장단점

-   간단한 page를 구성하기 위해 과거에서 가장 많이 사용되었던 architecture
<table>
<tr>
<td>장점</td>
<td>단점</td>
</tr>
<tr>
<td>구조가 단순하며 직관적이기 때문에 배우기 쉽다.</td>
<td>출력을 위한 view(html) 코드와 로직 처리를 위한 java 코드가 섞여 있기 때문에 JSP 코드 자체가 복잡해진다.</td>
</tr>
<tr>
<td>개발 시간이 비교적 짧기 때문에 개발 비용이 감소</td>
<td>JSP 코드에 Back-End(Developer)와 Front-End(Designer)가 혼재되기 때문에 분업이 힘들어진다.</td>
</tr>
<tr>
<td></td>
<td>project의 규모가 커지게 되면 코드가 복잡해 지므로 유지보수 하기가 어려워진다.</td>
</tr>
<tr>
<td></td>
<td>확장성(신기술의 도입, framework 등...)이 나쁘다.</td>
</tr>
</table>

## Model2(MVC Pattern)

### Model2 구조

-   model2는 모든 처리를 JSP 페이지에서 하는 것이 아니라, client 요청에 대한 처리는 servlet이, logic 처리는 java class(Service, DAO, ..), client에게 출력하는 response page를 JSP가 담당한다.
-   model2 구조는 MVC(Model-View-Controller) pattern을 웹개발에 도입한 구조이며 완전히 같은 형태를 보인다.

|            Model2            | MVC Pattern | 설명                                                                                                                                                                                                       |
| :--------------------------: | :---------: | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Service, DAO or<br>JavaBeans |    Model    | Logic(Business & DB Logic)을 처리하는 모든 것.<br>controller로부터 넘어온 data를 이용하여 이를 수행하고 그에 대한 결과를 다시 controller에 return 한다.                                                    |
|             JSP              |    View     | 모든 화면 처리르 담당. Client의 요청에 대한 결과 뿐 아니라 controller에 요청을 보내는 화면도 jsp에서 처리한다.<br>Logic처리를 위한 java code는 사라지고 결과 출력을 위한 code만 존재                       |
|           Servlet            | Controller  | Client의 요청을 분석하여 Logic처리를 위한 Model단을 호출한다.<br>return 받은 결과 data를 필요에 따라 request, session등에 저장하고, <br>redirect 또는 forward 방식으로 jsp(view) page를 이용하여 출력한다. |

img 삽입

### Model2 구조의 장단점

-   ㅐModel2는 Model1의 단점을 보완하기 위해 만들어졌으나, 다루기 어렵다는 단점이 ㅠ있다.

| 장점                                                                                                                  | 단점                                |
| :-------------------------------------------------------------------------------------------------------------------- | :---------------------------------- |
| 출력을 위한 view(html)코드와 로직 처리를 위한 java 코드가 분리되었기 때문에 JSP는 Model1에 비해 코드가 복잡하지 않다. | 구조가 복잡하여 초기 진입이 어렵다. |
| 화면단과 Logic단이 분리되었기에 분업이 용이해 졌다.                                                                   | 개발 시간의 증가로 개발 비용 증가   |
| 기능에 따라 code가 분리되었기 때문에 유지 보수가 쉬워졌다.                                                            |                                     |
| 확장성이 뛰어나다.                                                                                                    |                                     |

# EL(Expression Language)

-   EL은 표현을 위한 언어로 JSP 스크립트의 표현식을 대신하여 속성 값을 쉽게 출력하도록 고안된 language이다.
-   즉 표현식 <%= %>를 대체할 수 있다.
-   EL 표현식에서 도트 연산자 왼쪽은 반드시 java.util.Map 객체 또는 Java Bean 객체여야 한다.
-   EL 표현식에서 도트 연산자 오른쪽은 반드시 맵의 키이거나 Bean 프로퍼티여야 한다.

<br>

-   EL에서 제공하는 기능
    -   JSP의 네가지 기본 객체(page context, request, session, application)가 제공하는 영역의 속성 사용(setAttribute, getAttribute, removeAttribute)
    -   자바 클래스 메소드 호출 기능
    -   표현 언어만의 기본 객체 제공
    -   수치, 관계, 논리연산 제공

### EL 문법

-   Map을 사용하는 경우
    ```jsp
    ${Map.Map의키}
    ```
-   Java Bean을 사용하는 경우
    ```jsp
    ${JavaBean.Bean프로퍼티}
    ```

#### []연산자

-   EL에는 Dot 표기법 외에 [] 연산자를 사용하여 객체의 값에 접근할 수 있다.
-   [] 연산자 안의 값이 문자열인 경우, 이것은 맵의 키가 될 수도 있고, Bean 프로퍼티나 리스트 및 배열의 인덱스가 될 수 있다.
-   배열과 리스트인 경우, 문자로 된 인덱스 값은 숫자로 변경하여 처리합니다.

```jsp
${userinfo["name"]}
${userinfo.name}
```

리스트나 배열 요소에 접근

```jsp
// Servlet
String[] names = {"홍길동", "이순신", "임꺽정"};
request.setAttribute("userNames", names);

// jsp
${userName[0]} // 홍길동 출력
${userNames["1"]} // 문자열인 인덱스 값이 숫자로 바뀌어 userNames[1]의 결과인 이순신 출력
```

### EL 내장객체

EL 내장객체는 JSP 페이지의 EL 표현식에서 사용할 수 있는 객체

|       category        | identifier       |              Type               | description                                             |
| :-------------------: | :--------------- | :-----------------------------: | :------------------------------------------------------ |
|          JSP          | pageContext      |            JavaBean             | 현재 페이지의 프로세싱과 상응하는 PageContext instance. |
| 범위(scope) pageScope | Map              | page scope에 저장된 객체를 추출 |
|           ^           | requestScope     |               Map               | request scope에 저장된 객체를 추출                      |
|           ^           | sessionScope     |               Map               | session scope에 저장도니 객체를 추출                    |
|           ^           | applicationScope |               Map               | application scope에 저장된 객체를 추출                  |

|    category     | identifier   | Type | description                                                       |
| :-------------: | ------------ | :--: | ----------------------------------------------------------------- |
|  요청매개변수   | param        | Map  | ServletRequest.getParameter(String)을 통해 요청 정보를 추출       |
|        ^        | paramValues  |  ^   | ServletRequest.getParameterValues(String)을 통해 요청 정보를 추출 |
|    요청 헤더    | header       |  ^   | HttpServletRequest.getHeader(String)을 통해 헤더 정보를 추출      |
|        ^        | headerValues |  ^   | HttpServletRequest.getHeaders(String)을 통해 헤더 정보를 추출     |
|      쿠키       | cookie       |  ^   | HttpServletRequest.getCookies()를 통해 쿠키 정보를 추출           |
| 초기화 매개변수 | initParam    |  ^   | ServletContext.getInitParameter(String)를 통해 초기화 파라미터    |

### EL 사용

-   pageContext를 제외한 모든 EL 내장 객체는 Map 이다
-   그러므로 key와 value의 쌍으로 값을 저장하고 있다
-   기본문법

```jsp
${expr}
```

### EL에서 객체 접근

-   request.setAttribute("userinfo", "홍길동");
    1. ${requestScope.userinfo}
    2. ${pageContext.request.userinfo}, ${userinfo}
        - property 이름만 사용할 경우 자동으로 pageScope > requestScope > sessionScope > applicationScope 순으로 객체를 찾음
-   url?name=홍길동&fruit=사과&fruit=바나나
    1. ${param.name}
    2. ${paramValues.fruit[0]}, ${paramValues.fruit[1]}

<br>

EL에서 request 객체 접근

```jsp
Method is : ${pageContext.request.method}

// Servlet
request.setAttribute("ssafy.user", memberDto);

// case # 1 : 에러
${ssafy.user.name} // ssafy라는 속성은 존재하지 않음

// case # 2 : request 내장객체에서 [] 연산자를 통해 속성 접근
${requestScope["ssafy.user"].name}
```

-   ${cookie.id.value}
    1. Cookie가 null이라면 null return
    2. null이 아니라면 id를 검사 후 null이라면 null return
    3. null이 아니라면 value값 검사
        - EL은 값이 null이라도 null을 출력하지 않는다.(공백)

<br>

스크립트릿을 통한 쿠키 값 출력

```java
Cookie[] cookies = request.getCookies();
for(Cookie cookie : cookies){
    if(cookie.getName().equals("userId")){
        out.println(cookie.getValue());
    }
}
```

EL 내장 객체를 통한 쿠키 값 출력

```jsp
${cookie.userId.value}
```

### EL Operator

대부분 java와 동일

|            | description                                  |
| :--------: | :------------------------------------------- |
|    산술    | +, -, \*, /(div), %(mod)                     |
|   관계형   | ==(eq), !=(ne), <(lt), >(gt), <=(le), >=(ge) |
|  3항 연산  | 조건?값1:값2                                 |
|    논리    | &&(and), \|\|(or), !(not)                    |
| 타당성검사 | empty                                        |

empty 연산자에서 true를 return하는 경우. >> ${empty var}
<br>

1. 값이 null이면 true
2. 값이 빈 문자열이면 true
3. 길이가 0인 배열이면 true
4. 빈 Map 객체는 true
5. 빈 Collection 객체면 true

### EL에서 객체 method 호출

```jsp
<%
List<MemberDto> list = dao.getMembers();
request.setAttribute("users", list);
%>
```

-   회원수 : ${requestScope.users.size()}, ${users.size()}
-   주의 : ${users.size} == <%= request.getAttribute("users").getSize() %>

# JSTL(Jsp Standard Tag Library)

자바서버 페이지 표준 태그 라이브러리(JSTL)은 JavaEE 기반의 웹 애플리케이션 개발 플랫폼을 위한 컴폰전트 모음이다. JSTL은 XML 데이터 처리와 조건문, 반복문, 국제화와 지역화 같은 일을 처리하기 위한 JSP 태그 라이브러리를 추가하여 JSP 사양을 확장했다. JSTL은 JSP 페이지 내에서 자바 코드를 바로 사용하지 않고 로직을 내장하는 효율적인 방법을 제공한다. 표준화가 된 태그 셋을 사용하여 자바 코드가 들락거리는 것보다 더 코드의 유지보수와 응용 소프트웨어 코드와 사용자 인터페이스 간의 관심사의 분리로 이어지게 한다.

<br>
- custom tag: 개발자가 직접 태그를 작성할 수 있는 기능을 제공
- custom tag중에서 많이 사용되는 것들을 모아서 JSTL이라는 규약을 만듦
- 논리적인 판단, 반복문의 처리, 데이터베이스 등의 처리를 할 수 있다.
- JSTL은 JSP 페이지에서 스크립트릿을 사용하지 않고 액션을 통해 간단하게 처리할 수 있는 방법을 제공
- JSTL에는 다양한 액션이 있으며 EL과 함께 사용하여 코드를 간결하게 작성할 수 있다.

### JSTL tag

directive 선언 형식 : <%@ taglib prefix="prefix" uri="uri" %>

-   자주 쓰는 tag
    -   library : core
    -   prefix : c
    -   function : 변수 지원, 흐름제어, URL 처리
    -   URI : http://java.sun.com/jsp/jstl/core
