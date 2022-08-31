# Web Architecture
# HTML5 & CSS3 소개
## HTML 개요
- HTML은 Hypertext Markup Language의 약자
- 1990년도 이후 웹(Web, World Wide Web)에서 사용하는 문서 양식
- 문서에 하이퍼텍스트, 표, 목록, 비디오 등을 포함할 수 있는 tag(Tag)를 사용
- 문서를 Web Browser에 표현할 때 tag를 사용

## HTML5 개발 배경
- 수많은 플러그인들로 인한 Browser간의 부작용을 막기위해 개발
- HTML5 개발  단계
  - 익스플로러 독점
  - 익스플로러에 맞는 많은 플러그인 개발
  - 거대해져가는 브라우저 및 보안 취약점 발생
  - MS를 제외한 회사들이 HTML표준안을 W3C에 제시
  - HTML 표준안 무시
  - 무시당한 회사들이 Web Application 1.0 개발
  - W3C는 XHTML2.0 개발
  - XHTML2.0의 쇠퇴
  - W3C에서 Web Application 1.0을 웹표준안으로 수용
  - Web Application 1.0을 HTML5로 계명
  - 2014년 HTML5로 정식 배포
- HTML5의 탄생 목적은 기존의 Web Browser에 많은 플러그인이 설치되면서 많은 문제점이 발생했고, 이를 해결하기 위한 방안으로 W3C에서 Web Application1.0을 HTML5로 수용. 2014년에 정식으로 배포되었으며, 계속 업그레이드되고 있다.

## 웹표준이란?
- 모든 브라우저에서 웹서비스가 정상적으로 보여질 수 있도록 하는 것
- W3C(World Wide Web Consortium) - http://www.w3.org
  - 월드와이드웹(www)의 창시자인 팀 버너스 리를 중심으로 창립된 월드와이드웹 컨소시엄
- W3C에서 HTML5를 웹 표준으로 권고하고 웹 브라우저는 이를 따름

## HTML5의 특징
- HTML5는 지금도 개발 중에 있고, 다양한 기능이 추가됨
- 멀티미디어 요소 재생
  - 과거 브라우저는 멀티미디어를 재생하기 위해 별도의 외부 플러그인을 사용해야 했으나, HTML5에서는 멀티미디어 요소를 별도의 플러그인 없이도 재생 가능
- 서버와 통신
  - 서버와 클라이언트 사이에 소켓 통신이 가능
- Semantic tag 추가
  - 웹사이트를 검색엔진이 좀더 빠르게 검색할 수 있도록 하기 위해 특정 tag에 의미를 부여하는 방식
  - 예를 들어 \<header\> tag는 문서의 주제를 나타내는 tag로 \<header\> tag가 사용된 웹 문서의 경우 검색엔진은 웹문서의 모든 내용을 검색하는 것이 아닌 \<header\> tag의 내용만을 검색해서 보다 빠르게 검색을 진행할 수 있다.

## HTML 문서 구조
- \<!DOCTYPE html\> tag는 현재 문서가 HTML문서임을 정의
- 시작tag(\<tagname\>)와 종료tag(\</tagname\>)가 있으며, tag 사이에 문서 내용을 정의
- 각 tag는 고유의 의미를 가지고 있으며, Web Browser는 이 의미에 따라 문서를 화면에 표시

## Web & HTML 작동원리
- 서버는 클라이언트의 요청 내용을 분석하여 결과값을 HTML로 전송
- 서버는 결과값을 전송한 후 클라이언트와 연결 종료
- 클라이언트는 서버로부터 전달받은 HTML을 Web Browser에 표시
- 각 Web Browser는 브라우저 엔진이 내장되어 있고, 이 엔진이 tag를 해석하여 화면에 표현

## CSS 개요
- CSS(cascading Style Sheets)란 HTML 문서를 화면에 표시하는 방식을 정의한 언어
- W3C에서 공인한 표준
- 기존 웹 문서를 다양하게 설계하고, 변경 요구 대응에 따르는 어려움을 보완
- 어떤 Style을 적용 하느냐에 따라, 하나의 구조를 전혀 다른 페이지처럼 표현

## CSS 규칙
- CSS 규칙은 선택자(selector)와 선언(declaration) 두 부분으로 구성
- 선택자는 규칙이 적용되는 엘리먼트
- 선언 부분에서는 선택자에 적용될 스타일을 작성
- 선언은 중괄호로 감싸며, 속성(property)과 값(value)로 이루어짐.

<br>

- 속성(property)은 선택자에서 바꾸고 싶은 요소.(color, font, width, height, border, ...)
- 값(value)은 속성에 적용할 값
- 여러 선택자에 동일한 스타일을 적용할 때, comma(,)로 구분하여 나열.(선택자 그룹화)
- 선언 안에 하나 이상의 속성을 작성할 수 있으며, 각 속성은 semi-colon(;)으로 구분

## 스타일 적용방법
### 외부 스타일시트
- HTML문서에 스타일을 적용하는 방법은 외부 스타일시트, 내부 스타일시트, 인라인 스타일 3가지로 분류
- 외부 스타일시트(External Style Sheet)는 * .css 파일을 \<link\>나 @import로 HTML 문서에 연결하여 사용
- 하나의 CSS파일만 수정하면 해당 스타일시트를 사용하는 모든 페이지에 변경내용 적용
- 외부 스타일시트는 세가지 방법 중 가장 많이 사용

### 내부 스타일시트
- 내부 스타일시트(Embedded Style Sheet)는 \<style\>을 이용하여 HTML페이지 내부에 CSS적용
- \<style\>은 \<head\>안에 작성
- 내부 스타일 시트는 페이지마다 반복해서 작성하는 단점이 있다.
- 여러 페이지에 동일한 스타일을 적용해야 할 경우 외부 스타일시트를 사용

### 인라인 스타일시트
- 인라인 스타일(inline style)은 style attribute를 사용하여 개별 엘리먼트에 스타일을 적용
- Style 속성의 값은 CSS규칙의 선언(declaration)과 같다.
- 하나 이상의 속성을 적용할 수 있으며, semi-colon(;)으로 구분
- 세 가지 스타일을 모두 사용했을 때 가장 먼저 반영

# HTML5 기본
## HTML 개요
- HTML5 웹문서를 구성하는 3가지 요소
  - HTML : 웹 페이지 문서 담당(구조)
  - CSS : 웹 페이지 디자인 담당(표현)
  - JS : 웹 페이지 이벤트 담당(동작)

- HTML은 마크업 언어(markup language)로 웹문서를 작성하며, tag를 사용하여 문서의 구조 등을 기술하는 언어

## tag와 속성
- HTML 문서는 'tag'로 만들어진다.
- HTML 문서의 전체 구성은 html, head, body tag로 구성
- tag는 시작 tag와 종료 tag로 쌍을 이루거나 시작 tag만 존재하는 tag도 있다.
- 시작 tag(\<tagname\>)와 종료 tag(\</tagname\>)는 '/'로 구분하며 중첩되지 않도록 한다.
  - 시작과 종료 tag : \<body\> .. \</body\>
  - 시작 tag만 있는 경우 : \<br/\>, \<hr/\>, \<img/\>, ...
- 각각의 tag는 속성과 속성의 값이 존재한다.
- HTML tag에는 어느 tag에나 넣어서 사용할 수 있는 글로벌속성(global attribute)이 있다.
- 
|글로벌 속성|설명|
|:----|:----|
|class|tag에 적용할 스타일의 이름을 지정<br>ex)\<div class="content"\>...\</div\>|
|dir|내용의 텍스트 방향을 지정. 왼쪽 >> 오른쪽(기본값, ltr), 오른쪽 >> 왼쪽(rtl)<br>왼쪽 또는 오른쪽 정렬과 비슷한 형태로 표현<|
|id|tag에 유일한 ID를 지정함. 자바스크립트에서 주로 사용.<br>ex)\<input type="text" id="userid"\>|
|style|인라인 스타일을 적용하기 위해 사용<br>ex)\<p style="color: red; text-align: center;"\>빨간색 가운데</p>|
|title|tag에 추가 정보를 지정. tag에 마우스 포인터를 위치시킬 경우 title의 값 표시<br>ex)\<p\>\<abbr title="Web Application Server"\>WAS\</abbr\>는...\</p\>|

## 주석
- 주석의 내용은 브라우저에 출력이 되지 않는다.
- HTML tag의 내용을 설명하기 위한 용도로 사용

## Root 요소
- \<html\> tag는 HTML 문서 전체를 정의
- Head(\<head\> ... \</head\>)와 Body(\<body\> ... \</body\>)로 구성.

## Head 요소 - 문서 머리글(head), 제목(title)
- \<head\> tag는 브라우저에게 HTML 문서의 머리 부분임을 인식
- \<title\>, \<meta\>, \<style\>, \<script\>, \<link\> tag를 포함 가능.
- \<title\> tag는 문서의 제목을 의미, 브라우저의 제목 표시줄에 tag 내용이 나타남
- \<title\> tag 이외의 다른 tag로 표현한 정보는 화면에 출력 x

## Head 요소 - 메타 데이터(meta)
- 문서의 작성자, 날짜, 키워드 등 브라우저의 본문에 나타나지 않는 일반 정보를 나타냄
- name과 content 속성을 이용하여 다양한 정보를 나타냄
- http-equiv 속성을 이용하여 인코딩 설정 및 문서 이동, 새로 고침이 가능
- charset 속성을 이용하여 문서의 인코딩 정보를 설정

## Body 요소 - body
- Web Browser에 보여질 문서의 내용을 작성
- \<head\> tag 다음에 위치하고 \<head\> 내부에 위치하는 tag와 \<html\>을 제외한 모든 tag
- id 속성을 이용하여 문서 내에서 tag를 유일하게 식별 가능.(id속성은 중복x)
- class 속성을 이용하여 여러 tag에 공통적인 특성(CSS)을 부여.(class속성은 중복o)

## Body 요소 - heading
- 문단의 제목을 지정할 때 사용. \<h1\>부터 \<h6\>까지 구분. 숫자가 커질수록 글자는 작아짐
- \<section\> tag를 이용하면 같은 tag를 서로 다르게 표현
- 문서 구조를 \<section\> tag를 이용하여 구분하면 각 문단의 제목을 하나의 tag로 작성 가능

## 특수문자
|엔티티 이름|설명|화면출력|
|:--:|:--|:--:|
|\&nbsp;|Non-breaking space(공백)||
|\&lt;|Less than|<|
|\&gt;|Greater than|>|
|\&amp;|Ampersand|&|
|\&quot;|Quotation mark|"|
|\&copy;|Copyright|&copy;|
|\&reg;|registered trademark|&reg;|

# HTML5 Markup Elements
## 포맷팅 요소
- 포맷팅 요소에는 화면에는 동일하게 출력되지만 각 요소가 가진 의미가 다른 것이 있다.
- 예를 들면, \<b\>, \<strong\>은 모두 텍스트를 굵게 표현하지만, \<strong\>요소는 텍스트를 강조
|tag 명|설명|
|:--:|:--|
|\<abbr\>|생략된 약어 표시. Title 속성을 함께 사용|
|\<address\>|연락처 정보 표시.|
|\<blockquote\>|긴 인용문구 표시, 좌우로 들여쓰기가 됨.|
|\<q\>|짧은 인용문구 표시, 좌우로 따옴표가 붙음.|
|\<cite\>|웹 문서나 포스트에서 참고 내용 표시.|
|\<pre\>|공백, 줄 바꿈등 입력된 그대로 화면에 표시.|
|\<code\>|컴퓨터 인식을 위한 소스 코드.|
|\<mark\>|특정 문자열을 강조. 화면에는 하이라이팅 됨.|
|\<hr\>|구분선.|
|\<b\>, \<strong\>|굵은 글씨로 표히, 특정 문자열을 강조(\<strong\>)|
|\<i\>, \<em\>|이탤릭(기울게) 표시, 특정 문자열을 강조(\<em\>)|
|\<big\>, \<small\>|큰 글자, 작은 글자로 표시.|
|\<sup\>, \<sub\>|위 첨자, 아래 첨자로 표시.|
|\<s\>, \<u\>|취소선, 밑줄|

## 목록형 요소 - 개요
- 목록 tag는 하나 이상의 하위 tag를 포함
- 목록 tag는 각 항목을 들여쓰기로 표현
- 번호 또는 심볼을 이용해서 목록을 표현
|tag명|설명|
|:--:|:--|
|\<ul\>|번호 없는 목록을 표시, 항목 앞에 심볼을 표시.|
|\<ol\>|번호 있는 목록을 표시, 숫자, 알파벳, 로마숫자 등으로 표시.|
|\<li\>|목록 항목 \<ul\>이나 \<ol\>tag 하위에서 사용.|
|\<dl\>|용어 정의와 설명에 대한 내용을 목록화해서 표시.|
|\<dt\>|용어 목록의 정의 부분을 나타냄.|
|\<dd\>|용어 목록의 설명 부분을 나타냄.|

ol 태그 속성<br>
  <table>
    <thead>
      <td>속성</td>
      <td>속성값</td>
      <td>설명</td>
    </thead>
    <tbody>
      <tr>
        <td rowspan="5">type</td>
        <td>1</td>
        <td>숫자(기본값)</td>
      </tr>
      <tr>
        <td>a</td>
        <td>영문 소문자</td>
      </tr>
      <tr>
        <td>A</td>
        <td>영문 대문자</td>
      </tr>
      <tr>
        <td>i</td>
        <td>로마숫자 소문자</td>
      </tr>
      <tr>
        <td>I</td>
        <td>로마숫자 대문자</td>
      </tr>
      <tr>
        <td>start</td>
        <td>숫자</td>
        <td>시작번호</td>
      </tr>
      <tr>
        <td>reversed</td>
        <td></td>
        <td>역순으로 표시</td>
      </tr>
    </tbody>
  </table>

## table - HTML table 모델
- HTML table 모델은 데이터를 행(row)과 열(column)의 셀(cell)에 표시
- 행 그룹 요소인 \<thead\>, \<tbody\>, \<tfoot\> 요소를 사용하여 행들을 그룹화
- \<colgroup\>과 \<col\> 요소는 열 그룹을 위한 추가적인 구조정보를 제공
- table의 셀(cell)은 머리글(\<th\>)이나 데이터(\<td\>)를 가질 수 있음.

## table - table 스타일
- \<table\>, \<tr\>, \<td\> tag에는 table에 스타일을 적용하는 다양한 속성들이 있다.
- frame 속성은 table의 특정 선을 보여줄지를 결정하며, rules 속성은 셀과 셀사이의 줄이 나타날 것인가를 지정.
- table 정렬을 위한 align 속성, background, bgcolor, border 속성 등이 있음.
- HTML5부터는 이러한 속성들을 더 이상 지원하지 않는다. 스타일은 CSS를 사용하여 적용.

## table - table 제목
- \<caption\> tag는 table 제목을 정의하기 위해 사용하며 \<table\> start tag 바로 뒤에 위치
- \<caption\> tag는 table 당 하나만 사용
- table 제목은 기본적으로 가운데 정렬. 정렬 방식 변경은 CSS를 사용.

## table - 행(Row) 그룹 요소
- table 행 그룹 요소는 table의 행들을 머리글, 바닥글, 하나 이상의 본체 항목으로 그룹핑.
- 행 그룹 요소에는 머리글(\<thead\>), 본체항목(\<tbody\>), 바닥글(\<tfoot\>) 요소가 있다.
- 각 행 그룹은 최소 하나 이상의 \<tr\>을 가져야 함.

## table - 열(Column) 그룹 요소
- table 열 그룹 요소는 table 내에서 구조적인 분리를 가능케 함
- \<colgroup\> 요소는 명시적인 열 그룹을 만들며, \<col\> 요소는 열(column)을 묶어 그룹핑 함.
- \<colgroup\> 요소의 span 속성은 열 그룹에서 열의 개수를 정의.
- \<col\> 요소의 span 속성은 \<col\>에 의해 묶여진 열의 개수를 말함.

## table - 테두리(border)
- cellspacing은 table Cell 사이의 공간을 의미
- cellspacing은 Cell 외곽과 Cell 컨텐츠 사이 공간을 의미
- HTML5 부터는 테두리 스타일 관련 속성을 지원하지 않고, CSS를 사용.

## table - 셀 병합
- HTML table 의 \<td\>요소에는 셀(Cell)을 병합하기 위한 두개의 속성이 있음
- colspan 속성은 두 개 이상의 열(Column)을 하나로 합치기 위해 사용.
- rowspan 속성은 두 개 이상의 행(Row)을 하나로 합치기 위해 사용.

## 이미지 요소 - img
- \<img\> tag를 사용하며 이미지를 삽입하기 위해 사용.
- src 속성은 이미지 경로를 지정하기 위해 사용(상대경로, URL 모두 가능)
- height, width 속성은 이미지 사이즈를 지정하기 위해 사용
- alt 속성은 이미지를 표시할 수 없을 때 화면에 대신하여 보여질 텍스트를 지정.

<br>

- \<figure\>는 설명 글을 붙여야 할 대상을 지정
- \<figcaption\> : 설명 글이 필요한 대상은 \<figure\> 태그로 묶고 설명 글은 \<figcaption\>태그로 묶는다.
- 설명 글을 붙일 수 있는 대상은 이미지나 오디오, 비디오 같은 미디어파일이나 텍스트 단락이나 표.

## 링크 요소 - Anchor
- \<a\> tag를 사용하며, 하나의 문서에서 다른 문서로 연결하기 위해 (하이퍼링크) 사용.
- tag를 서로 중첩해서 사용할 수 없다.
- href 속성은 하이퍼링크를 클릭했을 때 이동할 문서의 URL이나 문서의 책갈피를 지정.
- target 속성은 하이퍼링크를 클릭했을 때 현재 윈도우 도는 새로운 윈도우에서 이동할지를 지정.

## 링크 요소 - target
|속성 값|설명|
|:--|:--|
|\_blank|링크 내용이 새 창이나 새 탭에서 열린다.|
|\_self|target 속성의 기본 값으로 링크가 있는 화면에서 열린다.|
|\_parent|프레임을 사용했을 때 링크 내용을 부모 프레임에 표시.|
|\_top|프레임을 사용했을 때 프레임에서 벗어나 링크 내용을 전체 화면으로 표시.|

## 링크 요소 - \#anchor
- 같은 페이지 안에서 특정 요소를 클릭 시 그 위치로 한 번에 이동시킨다.
- \<tag id="anchor name"\>text or image\</tag\>
- \<a href="#anchor name"\>text or image\</a\>

## 링크 요소 - map
- 하나의 이미지에 여러 개의 link(

# CSS3 기본
# CSS3 이해
# Semantic
