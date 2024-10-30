package com.example.todo_api.todo;

import com.example.todo_api.member.Member;
import com.example.todo_api.member.MemberRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.beans.Transient;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @Transactional // 실행 범위 설정
    @Rollback(false) // 테스트 환경에서는, 에러 발생 안해도 테스트 끝나면 알아서 롤백 해줌
    // 따라서, 수동으로 롤백을 꺼줘야 디비에 값을 확인할 수 있음
    void todoSaveTest() {

        // 트랜잭션의 시작

        Todo todo = new Todo("todo content", false, null);
        todoRepository.save(todo);

        // 트랜잭션의 끝 -> 커밋
        // 에러 발생 시, 자동으로 롤백

        Assertions.assertThat(todo.getId()).isNotNull();
    }

    @Test
    @Transactional
    void todoFindOneByIdTest() {
        // given
        Todo todo = new Todo("todo content", false, null);
        todoRepository.save(todo);

        todoRepository.flushAndclear();

        // when
        Todo findTodo = todoRepository.findById(todo.getId());

        // then
        Assertions.assertThat(findTodo.getId()).isEqualTo(todo.getId());
    }

    @Test
    @Transactional
    void todoFindAllTest() {
        Todo todo1 = new Todo("todo content1", false, null);
        Todo todo2 = new Todo("todo content2", false, null);
        Todo todo3 = new Todo("todo content3", false, null);
        todoRepository.save(todo1);
        todoRepository.save(todo2);
        todoRepository.save(todo3);

        List<Todo> todoList = todoRepository.findAll();

        Assertions.assertThat(todoList).hasSize(3);

    }

    @Test
    @Transactional
    @Rollback(false)
    void todoFindAllByMemberTest() {
        Member member1 = new Member("1", "asd");
        Member member2 = new Member("2", "qwe");
        memberRepository.save(member1);
        memberRepository.save(member2);

        Todo todo1 = new Todo("todo content1", false, member1);
        Todo todo2 = new Todo("todo content2", false, member1);
        Todo todo3 = new Todo("todo content3", false, member2);
        todoRepository.save(todo1);
        todoRepository.save(todo2);
        todoRepository.save(todo3);

        List<Todo> member1TodoList = todoRepository.findAllByMember(member1);
        List<Todo> member2TodoList = todoRepository.findAllByMember(member2);

        Assertions.assertThat(member1TodoList).hasSize(2);
        Assertions.assertThat(member2TodoList).hasSize(1);

    }

    @Test
    @Transactional
    @Rollback(false)
    void todoUpdateTest() { // 수정은 레포지토리 계층이 아닌, 엔티티 클래스에서 한다!
        Todo todo1 = new Todo("todo content1", false, null);
        todoRepository.save(todo1);

        todoRepository.flushAndclear();

        Todo findTodo1 = todoRepository.findById(todo1.getId()); // 조회 후
        findTodo1.updateContent("new Content"); // 수정

    }

    @Test
    @Transactional
    @Rollback(false)
    void todoDeleteTest() {

        Todo todo1 = new Todo("todo content1", false, null);
        Todo todo2 = new Todo("todo content2", false, null);
        todoRepository.save(todo1);
        todoRepository.save(todo2);

        todoRepository.flushAndclear();

        todoRepository.deleteById(todo1.getId());
    }

    @AfterAll // 모든 테스트가 끝났을 때
    public static void doNotFinish() {
        System.out.println("test finished");
        while (true) {}
    }
}
