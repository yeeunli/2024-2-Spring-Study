package com.example.todo_api.todo;

import com.example.todo_api.member.Member;
import com.example.todo_api.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor // 생성자 주입
public class TodoService {

    private final TodoRepository todoRepository;
    private final MemberRepository memberRepository;

    public void createTodo(String content, Long memberId) throws Exception {

        Member member = memberRepository.findById(memberId);

        if (member == null) {
            throw new Exception("존재하지 않는 멤버입니다.");
        }

        Todo todo = new Todo(member, content);
        todoRepository.save(todo);
    }

    // 할 일 조회
    @Transactional(readOnly = true)
    public List<Todo> getTodoList(Long memberId) throws Exception {
        Member member = memberRepository.findById(memberId);
        if(member == null) {
            throw new Exception("존재하지 않는 멤버입니다.");
        }

        return todoRepository.findAllByMember(member);
    }

    // 할 일 수정
    @Transactional
    public void updateTodo(Long todoId, Long memberId, String updateContent) throws Exception {
        Todo todo = todoRepository.findById(todoId);
        Member member = memberRepository.findById(memberId);

        if (todo == null) {
            throw new Exception("존재하지 않는 할 일 입니다.");
        }

        if (member == null) {
            throw new Exception("존재하지 않는 멤버입니다.");
        }

        if (todo.getMember() != member) {
            throw new Exception("다른 유저의 할 일을 수정할 수 없습니다.");
        }

        todo.updateContent(updateContent);
    }

    // 할 일 삭제
    @Transactional
    public void deleteTodo(Long todoId) throws Exception {
        Todo todo = todoRepository.findById(todoId);
        if (todo == null) {
            throw new Exception("존재하지 않는 할 일 입니다.");
        }
        todoRepository.deleteById(todoId);
    }
}
