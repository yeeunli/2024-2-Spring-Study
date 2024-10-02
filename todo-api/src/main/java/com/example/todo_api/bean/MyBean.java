package com.example.todo_api.bean;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//// 필드 주입
//@Getter
//@Component
//public class MyBean {
//
//    @Autowired
//    private MySubBean mySubBean;
//}

// 생성자 주입
@Getter
@Component
@RequiredArgsConstructor // 이거 한 방이면 final 필드에 대한 생성자 자동 생성
public class MyBean {

    private final MySubBean mySubBean; // 이렇게 간단히 의존성 주입이 완료!
}


//@Component
//public class MyBean {
//
//    private final MySubBean mySubBean; // final: const와 비슷한 기능 (바뀔 값이 아니다!)
//
////    @Autowired // 클래스에 생성자가 하나만 존재한다면, @Autowired 생략 가능
//    public MyBean(MySubBean mySubBean) {
//        this.mySubBean = mySubBean;
//    }
//}
