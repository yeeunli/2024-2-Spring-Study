package com.example.todo_api.bean;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
public class BeanTest2 {

    @Autowired // 여기가 통로야!
    private MyBean myBean;

    @Autowired // 여기가 통로야!
    private MySubBean mySubBean;

    @Test
    public void dependencyInjection() {
        // 필드 주입으로 가져온 myBean과 mySubBean 사용해서 동일한지 테스트

        System.out.println(myBean.getMySubBean());
        System.out.println(mySubBean);

        Assertions.assertThat(myBean.getMySubBean()).isSameAs(mySubBean);
    }
}
