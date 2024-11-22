# 2024-2-Backend-Study

2024년 2학기에 진행되는 스프링으로 진행되는 백엔드 스터디 커리큘럼 과제 제출입니다.

---

## 🎈 오늘은 뭘 배워볼까? 🎈

👩‍🏫 api 문서화를 알아보고, 프로젝트 배포를 해보자

---

### api 문서화

- 백엔드가 만든 API에 대한 사용법을 공유하기 위함
- 대표적인 API 문서화 도구인 **swagger**를 통해 자동화를 해보자
- @ApiResponse를 사용하여 status code마다 description 적기 가능

1. implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0' → 의존성 추가 후 실행하면
2. http://localhost:8080/v3/api-docs → 이 pretty-print를 기반으로 만들어진 문서를
3. http://localhost:8080/swagger-ui/index.html#/ → swagger-ui와 같은 도구를 통해 이해하기 쉽게 문서화 가능

### 프로젝트 배포

> 서버 컴퓨터에서 24시간 서버를 실행시켜 두는 것
> 여러 소스코드를 합치는 빌드 과정을 거쳐 실행

1. ./gradlew.bat build → **로컬**에서 어플리케이션 빌드 (여러가지 외부 라이브러리를 포함한 모든 코드를 하나의 실행파일로 묶어주는 과정) → jar 파일 생성됨
2. java -jar .\build\libs\board-api-0.0.1-SNAPSHOT.jar (명령줄에서 자바 명령어를 통해 서버를 실행)
3. Koyeb에서 소스코드가 올라와있는 깃허브와 연동 후 서버 연결 (Koyeb 내부에서 자체적으로 jar 파일 생성 후 실행되는 원리)

---

## 이번 주차를 공부한 뒤 느낀점은❔

🧸: 원래 swagger 볼 줄도 몰랐는데 그냥 내가 만들었던 코드로 의존성 한 줄만 추가하면 실행돼서 신기했고, ,,
실제 배포까지 경험해볼 수 있었는데, 앞으로 내가 헤쳐나갈 프로젝트에 두려움 한 덩이를 뺴낸 것 같아 홀가분했고, 배포를 내가 했다는 성취감이 뜻깊은 시간이었다.
