# 2024-2-Backend-Study

2024년 2학기에 진행되는 스프링으로 진행되는 백엔드 스터디 커리큘럼 과제 제출입니다.

---

## 🎈 오늘은 뭘 배워볼까? 🎈

👩‍🏫 컨트롤러 계층에서 api 통신을 시도해보자

---

#### 컨트롤러 계층

- 클라이언트 요청 받고, 응답 보내기
- `DTO`를 통해 서비스 계층과 데이터 주고받음
- `@Controller`로 컴포넌트 스캔 (`@RestController`가 더 편리)

#### 어노테이션

- `@ResponseBody`

  - 자바 객체를 `JSON` 형식으로 변환하여 데이터 응답

- `@RequestMapping`

  - 메서드가 처리할 요청 method(ex. POST)와 URL 지정

  - 하지만, 요청 method 종류는 `@(method종류)Mapping`으로 간편하게 지정 (ex. `@PostMapping`)

- `@RequsetBody`

  - 파라미터를 통해 `JSON` 형식으로 들어오는 요청 데이터
  - `DTO`: 데이터를 받는 자바 객체 (순수한 자바 클래스)
  - 덕분에, 나만의 퍼스널 데이터들을 DTO로 한방에 받기 가능!

#### 응답 생성

- 상태 코드

  - 클라이언트의 요청을 처리했다면, 처리 결과를 클라이언트에게 알려줘야겠지?
    - 200 - ok
    - 201 - created
    - 400 - bad request
    - 404 - not found
    - 500 - internal server error

- `@ResponseEntity`
  - HTTP 응답 반환

#### 컨트롤러 테스트

- API 테스트 도구
  - postman

---

## 이번 주차를 공부한 뒤 느낀점은❔

🧸: 게시판 api를 만들 때, postman 사용법을 제대로 몰라서 연결이 되는데, 안 되었는 줄 알았다. 하지만, 이번 스터디에서 사용법을 익히고 나니 내 코드가 정상 작동했음을 알 수 있었다. 또한, 컨트롤러 계층 외에도 서비스, 레포지토리 계층 간의 관계를 이제는 조금은 이해를 한 것 같고, 그들간의 유기성의 장점이 와닿는 중이다. 이번 스터디에서 대충 DTO가 어떤 역할인지 감을 잡았기에 10주차 스터디에서 DTO의 쓰임에 대해 더 명확히 알아보고 싶다.