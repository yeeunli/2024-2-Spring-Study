package com.example.todo_api.hw;

import lombok.RequiredArgsConstructor;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyController {

    private final MyService myService;

    public void controllerMethod() {
        myService.serviceMethod();
        System.out.println("controller");
    }

}
