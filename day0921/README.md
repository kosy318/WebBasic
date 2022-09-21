# MVC

<img src="https://user-images.githubusercontent.com/77595685/191387915-9ced1d09-35bb-4e72-a43c-417597998770.png" style="width: 1000px;">

server 탭 -> 서버 오른쪽 클릭 > Add and Remove
<br>
server.xml -> context 바꿈
<br>
project > 오른쪽 클릭 > Properties > Web Proejct Settings > Context root 바꿈

### 순서
1. Workspace 바꾸기
2. encoding 설정, server setting(tomcat)-tomcat이 있는 폴더 미리 체크
3. project import 후 환경 설정(Build path, Server, Targeted Runtimes check)
4. table 생성
5. DBUtil.java 열어서 DB이름, 계정명, 패스워드 체크
6. 패키지 생성: front controller, controller, service, dao, vo
7. VO 생성
8. interface 생성: Service, DAO
9. Impl 클래스 생성(구현은 나중에)
10. FrontController, Controller 생성-요청 url 정하기