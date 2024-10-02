package com.example.todo_api.hw;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyControllerTest {

    @Autowired // 여기가 통로야!
    private MyController myController;

    @Test
    public void myControllerTest() {
        myController.controllerMethod();
    }
}