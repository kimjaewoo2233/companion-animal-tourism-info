# companion-animal-tourism-info

# 프로젝트 보고서 20175209 김재우

<h3>반려동물과 함께 다녀온 관광지에 대한 후기도 남기고 동물보호소 정보와 지도를 한 눈에 볼 수 있는 사이트</h3>
<hr>

<h2>주제 이유</h2>
<br>
 최근 반려동물을 키우는 사람들이 증가하고 있고 10가구 중 3가구는 반려동물을 키우고 있다고 봐도 될 정도로 많은 사람들이 반려동물과 함께 생활하고 있다. 그런만큼 반려동물과 함꼐 관광을 다니는 사람들이 많을 것이라는 점에서 아이디어를 얻게되었다. 기존에 카페, 블로그들에서도 이런 관광후기를 남기는 사이트가 있지만 그 안에서 동물보호소에 관한 정보를 볼 수 있는 곳은 크게 없다는 생각이 들어 이런 점에서 차별화를 두었다. 

<h2>기술스택</h2>
  Springboot, SpringDataJPA, SpringSecurity, JQuery, Bootstrap, axios, OpenAPI(Naver 검색, 공공데이터, 카카오맵) 
  



<h2>전체적인 백엔드 구성</h2>

![image](https://user-images.githubusercontent.com/79129475/206648243-c7202909-00a9-4259-8975-fe1006852114.png)
<h3>1. Client에서 서버로 요청을 날린다.</h3>
제일 웹서버에 접근하기 전 Filter에서 로그인 처리과정을 거친다. 대표적으로 로그인 처리필터(UsernamePasswordAuthenticationFilter)가 있다. Spring Security는 DelegatingFilterProxy Filter를 만들어서 메인 Filter Chain에 끼워넣고 SecurityFilterChain 그룹에 등록시킨다. 이 과정에서 메인페이지에 들어온 요청을 검증을 하지 않고 바로 볼 수 있록 만들었다. 로그인 인증처리는 후기 게시판 CRUD 접근시 하게 개발하였다.

![image](https://user-images.githubusercontent.com/79129475/206649487-aebd304c-8b32-46c3-ac2f-52b2c949963f.png)

 > 그림출처 - https://velog.io/@seongwon97/Spring-Security-Filter%EB%9E%80
 
 
 <h2>MainController에 요청을 들어올 경우</h2>
 <br>
 Spring은 FrontController에서 요청을 먼저 받고 이후 해당 경로에 맞는 Controller로 요청이 전달된다. 그렇게 전달된 요청을 처리하는 곳이 MainController이다. 이 Controller에서는 MVC 2 패턴으로 동작을 하여 HTML파일을 보여준다. boot를 사용했으므로 JSP가 아닌 Thymeleaf를 사용했다.
 이 Controller에서 html 파일에 보낼 데이터를 Sevice 클래스에 요청을 보내 데이터를 받아온다. 
 
 <h2>Service </h2>
 <br>
위에 Controller에서 필요한 데이터를 Service로 요청을 보낸다. 그렇게 Service 클래스는 요청을 받아 DB에 쿼리를 날려 응답을 받아온다. 여기서 기본 쿼리가 아닌 Spring Data JPA 를 사용해서 기존에 쿼리가 아닌 쿼리메소드(JpaRepository)를 통해 데이터를 받아오고 바로 객체로 매핑하는 방식으로 개발하였다. Controller에서 Entity에 변환이 일어나면 안된다. 그렇기에 여기서는 Controller에서 DTO를 사용하게 하고 Service 로직에서는 Entity를 사용하게 했다.
<br>


![image](https://user-images.githubusercontent.com/79129475/206824425-c34cf21f-334f-4ae0-bb77-6e84863bb50c.png)

> 그림출처 https://gmlwjd9405.github.io/2018/12/25/difference-dao-dto-entity.html


<h2>index.html에서 DataController로 요청 날리기</h2>
index.html은 MVC 패턴으로 클라이언트한테 넘어가는 html 파일이다. 여기서 단점은 데이터가 바로 바뀌지 않고 새로고침이나 다른 주소로 요청을 보내야만 컨트롤러를 거치면서 데이터에 변환이 일어난다. 그렇기에 비동기 방식을 사용하여 데이터를 받는 방식이 필요했다. 그렇게 DataController를 RestController로 만들었다. 그렇게 JSON으로 데이터요청을 주고 받는 방식으로 DataController를 개발했다. DataController도 마찬가지로 Service클래스를 통해 DB에 데이터를 처리하며 DTO와 Entity를 사용하여 주고받는 형식이다.

<h2>메인페이지</h2>

> 메인페이지 접속
![image](https://user-images.githubusercontent.com/79129475/206825031-42321fbd-1e16-4bcc-b0d6-0d814eb32097.png)
> 페이지에 접속하면 바로 볼 수 있는 화면이다 read more을 클릭하면 후기남기는 게시판으로 이동한다.
![image](https://user-images.githubusercontent.com/79129475/206825046-e906b8bd-696d-4941-9226-d798fc5f3729.png)
> 네이버 검색 API를 통해 반려동물과 관광지를 다녀온 후 남긴 후기들을 응답 값으로 받아 넣어놨다. 사각형을 클릭하면 블로그로 이동한다.
![image](https://user-images.githubusercontent.com/79129475/206825078-8bb9b4d6-c9a3-452f-8d72-e259840df4fd.png)
> 옆에 두 버튼이 있고 버튼 하나는 후기 게시판으로 넘어가고 나머지 한 개는 동물보호소 정보 보는 곳으로 화면이 이동한다.
![image](https://user-images.githubusercontent.com/79129475/206825087-adfe95fc-207f-4047-a39e-6a7a3406f172.png)
> 공공데이터 포털에서 동물보호소에 대한 정보를 API로 받아 데이터를 보이게 한 것이다.
![image](https://user-images.githubusercontent.com/79129475/206825096-6539af0d-ae49-4f2c-8ee7-6ed4805bcfe4.png)
> 받은 데이터에 위치를 카카오 맵으로 보여지게 만들었다.
![image](https://user-images.githubusercontent.com/79129475/206825107-cfc76e3a-0e4e-476a-9b11-209a00f24c38.png)
> 관광후기 게시판이고 글에 대한 CRUD 처리를 하기 위해서는 로그인이 필요하다. 페이징처리까지 하여 밑에 페이징으로 편리하게 볼 수 있다/
![image](https://user-images.githubusercontent.com/79129475/206825115-33ec35ca-591e-4d8b-8939-689c05246433.png)
> 글을 보는 곳에 들어가는 화면이고 만약 접속한 사용자와 글을 쓴 사용자가 같은 사용자라면 수정,삭제 버튼이 나온다.
![image](https://user-images.githubusercontent.com/79129475/206825127-c9bb76c5-4b48-4d16-8f24-d6f2feab1793.png)





