package com.example.todo_api.member;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor()
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_login", columnDefinition = "varchar(20)")
    private String login;

    @Column(name = "member_pw", columnDefinition = "varchar(20)")
    private String password;

    public Member(String login, String password) {
        this.login=login;
        this.password=password;
    }
}
