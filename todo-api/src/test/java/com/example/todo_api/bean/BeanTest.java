package com.example.todo_api.bean;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTest {

    ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);


    @Test
    public void getAllBeans() {

        // 스프링 컨테이너를 설정 파일 정보 이용하여 생성
        // 그리고, 스프링 컨에티너 안에 있는 모든 빈을 조회하는 테스트
        for (String name: context.getBeanDefinitionNames()) {
            System.out.println(name);
        }

        // context 안에 myBean이 들어있는지 검증
        Assertions.assertThat(context.getBeanDefinitionNames()).contains("myBean");
    }

    @Test
    public void getOneBean() {
        MyBean myBean1 = context.getBean(MyBean.class);
        MyBean myBean2 = context.getBean(MyBean.class);

//        MyBean myBean3 = new MyBean();

        System.out.println(myBean1); // 고유값 4f0100a7
        System.out.println(myBean2); // 고유값 4f0100a7
//        System.out.println(myBean3); // 고유값 3cdf2c61

        Assertions.assertThat(myBean1).isSameAs(myBean2); // 테스트 통과
        // Assertions.assertThat(myBean1).isSameAs(myBean3); // 테스트 실패 (tests failed)
    }

    @Test
    void dependencyInjection() {
        MyBean myBean = context.getBean(MyBean.class);
        MySubBean mySubBean = context.getBean(MySubBean.class);

        System.out.println(myBean.getMySubBean());
        System.out.println(mySubBean);

        Assertions.assertThat(myBean.getMySubBean()).isSameAs(mySubBean);
    }
}
