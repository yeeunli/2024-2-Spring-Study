package com.example.todo_api.todo;

import com.example.todo_api.member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.h2.engine.User;

@Entity // 나는 entity다!!
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
public class Todo {

    @Id // 내가 pk다!!
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="todo_id")
    private Long id; // bigint가 long임

    @Column(name = "todo_content", columnDefinition = "varchar(200)")
    private String content;

    @Column(name="todo_is_checked", columnDefinition = "tinyint(1)")
    private boolean isChecked;

    @JoinColumn(name="member_id")
    @ManyToOne(fetch = FetchType.LAZY) // todo 관점이니까 many가 먼저 나오겠지?
    private Member member; // 외래키 -> 외래키 필드를 그냥 넣어주면 끝!

    public Todo(Member member,String content) {
        this.content = content;
        this.isChecked = false;
        this.member = member;
    }

    public void updateContent(String newContent) {
        this.content = newContent;
    }

}
