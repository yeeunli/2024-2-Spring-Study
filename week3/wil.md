# 2024-2-Mobile-Study

2024년 2학기에 진행되는 스프링으로 진행되는 백엔드 스터디 커리큘럼 과제 제출입니다.

---

## 🎈 오늘은 뭘 배워볼까? 🎈

👩‍🏫 스프링 빈과 컨테이너에 대해 알아보자❕

---

### 스프링 애플리케이션 구조

1. api를 호출하면
2. 이 api만을 담당하는 전용 컨트롤러 불러짐
3. DB에서 전체 todo list를 자바 객체로 반환
4. 프론트-백 소통을 위해 JSON 형식으로 변환
5. HTTP Body에 데이터를 담아 응답 전송

### 스프링과 스프링부트 둘은 무슨 관계인가

스프링부트가 스프링 내의 내장 웹서버 연동 및 DB 연결 등을 도와주는 관계

### 스프링 빈이 무엇인가

> 어플리케이션 전역에서 사용할 공용 객체 (하나의 자바 객체)
> 스프링 컨테이너에 빈 즉, 객체를 저장해두고, 필요한 빈을 컨테이너에서 받아 사용

#### 누가 빈을 필요로 하는가

> 바로 빈!
> 빈들은 서로서로 필요로 하는 관계

### 스프링 컨테이너가 무엇인가

> 스프링 빈이 저장되는 공용 창고로, 어플리케이션 컨텍스트로도 불림

### 스프링 빈을 컨테이너에 어떻게 저장하는가

1. 설정 파일 작성 (수동 등록)
   등록하고 싶은 자바 객체를 설정 파일에 하나씩 적어주자
   - 클래스에 `@Configuration`, 메서드에 `@Bean` 어노테이션 사용
   - 스프링 빈은 1개의 객체이므로, 컨테이너에서 빈을 가져올 때마다 같은 객체 반환
2. 컴포넌트 스캔 (자동 등록)
   어플리케이션 실행 시, 등록해둔 모든 클래스들을 훑어본 뒤 표시된 객체만 자동으로 생성
   - 빈을 생성할 클래스에 `@Component` 어노테이션 사용이 끝!!! (초간단)
   - 어플리케이션을 시작할 때 `@Component`가 붙은 클래스를 찾아서 자동으로 빈 등록
   - 테스트 시, `@ComponentScan` 어노테이션으로 컴포넌트 스캔

### 컨테이너에서 어떻게 가져오는가

> 의존성에 주목하자
> 즉, 필요한 빈(의존성)을 요청하고 받아서 사용

#### 의존성 주입이 뭔데?

스프링 → 프레임워크가 컨테이너에 저장된 빈(객체)과 빈(객체)사이의 의존성 주입

#### 왜 쓰는데?

- OCP 원칙 준수 (새로운 기능 추가 원할 때, 기존 코드 변경하지 않으면서 기능 추가 가능하게 하는 것)
- 효율적인 메모리 활용

1. 생성자 주입
   `final` 키워드로 필요한 의존성 추가
   `@RequiredArgsConstructor`로 생성자 추가
2. 필드 주입
   필드에 바로 `@Autowired` 어노테이션 사용 (`final` 사용 불가)
   주로 테스트 코드에서 사용한다
3. 세터 주입

### 스프링 어플리케이션 개발 시, 어떤 구조로 개발하는가

컨트롤러 - 서비스 - 레포지토리 - DB(스프링 외부) 로 개발되며,
이들 사이의 데이터는 DTO, entity 등으로 전달

---

## 이번 주차를 공부한 뒤 느낀점은❔

🧸: 그 동안 궁금했던 개념들에 대해 알 수 있었다. 특히, 어노테이션을 쓰는 방식에 대해 의문이 있었는데 오늘 그 여러 가지 종류 중 주요 기능들을 알게 되어 속이 후련했다. 또한, 컨트롤러와 서비스, 레포지토리 간의 관계 또한 알게되어 앞으로 프로젝트에 도움이 될 것 같다.
