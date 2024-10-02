package com.example.todo_api.hw;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyService {

    private final MyRepository myRepository;

    public void serviceMethod() {
        myRepository.repositoryMethod();
        System.out.println("service");
    }


}
