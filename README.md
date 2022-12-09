# companion-animal-tourism-info

# 프로젝트 보고서 20175209 김재우

<h3>반려동물과 함께 다녀온 관광지에 대한 후기도 남기고 동물보호소 정보와 지도를 한 눈에 볼 수 있는 사이트</h3>
<hr>

<h2>주제 이유</h2>
<br>
 최근 반려동물을 키우는 사람들이 증가하고 있고 10가구 중 3가구는 반려동물을 키우고 있다고 봐도 될 정도로 많은 사람들이 반려동물과 함께 생활하고 있다. 그런만큼 반려동물과 함꼐 관광을 다니는 사람들이 많을 것이라는 점에서 아이디어를 얻게되었다. 기존에 카페, 블로그들에서도 이런 관광후기를 남기는 사이트가 있지만 그 안에서 동물보호소에 관한 정보를 볼 수 있는 곳은 크게 없다는 생각이 들어 이런 점에서 차별화를 두었다. 

<h2>기술스택</h2>
  Springboot, SpringDataJPA, SpringSecurity, JQuery, Bootstrap, axios, OpenAPI(Naver 검색, 공공데이터, 카카오맵) 
  
<h2>Nodejs를 쓰지 않은 이유</h2> 
<br>
Node가 확실히 Spring보다 가볍고 빠른 건 사실이지만, 유지보수나 객체지향 측면에서는 Spring이 훨씬 좋다 생각하여 Node를 쓰지 않았다. 현재 프로젝트 규모는 상당히 가벼운 작업이지만 추후 더 작업을 해보고 추가할 생각이기에 Node를 쓰지 않았다. Node는 single-thread 동작이라 부하가 큰 단일 작업을 수행해야하는 경우는 성능 저하를 피하지 못한다. Spring은 동기방식에 Node에 비해 무거워서 현재 프로젝트 정도에서 사용하기에 Node가 적합할 수도 있다고 생각했지만 이번 학기가 끝난 이후 조금 더 기능을 추가하고 규모를 키울 생각이기에 그때가서 Node로 개발하였을시 문제점이 더 크게 나올 거 같아 Spring으로 개발을 시작하였다.

<h2>전체적인 백엔드 구성</h2>

![image](https://user-images.githubusercontent.com/79129475/206648243-c7202909-00a9-4259-8975-fe1006852114.png)
<h3>1. Client에서 서버로 요청을 날린다.</h3>
제일 웹서버에 접근하기 전 Filter에서 로그인 처리과정을 거친다. 대표적으로 로그인 처리필터(UsernamePasswordAuthenticationFilter)가 있다. Spring Security는 DelegatingFilterProxy Filter를 만들어서 메인 Filter Chain에 끼워넣고 SecurityFilterChain 그룹에 등록시킨다. 이 과정에서 메인페이지에 들어온 요청을 검증을 하지 않고 바로 볼 수 있록 만들었다. 로그인 인증처리는 후기 게시판 CRUD 접근시 하게 개발하였다.

![image](https://user-images.githubusercontent.com/79129475/206649487-aebd304c-8b32-46c3-ac2f-52b2c949963f.png)

 > 그림출처 - https://velog.io/@seongwon97/Spring-Security-Filter%EB%9E%80

