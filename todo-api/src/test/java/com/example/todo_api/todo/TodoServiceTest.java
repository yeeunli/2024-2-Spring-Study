package com.example.todo_api.todo;

import com.example.todo_api.member.Member;
import com.example.todo_api.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    @Mock
    MemberRepository memberRepository;

    @Mock
    TodoRepository todoRepository;

    @InjectMocks
    TodoService todoService;

    @Test
    public void createTodoTest() throws Exception {
        // given
        // 테스트 할 때 필요한 사전 데이터 세팅
        BDDMockito.given(memberRepository.findById(1L)).willReturn(new Member());

        // when
        // 테스트 할 동작 실행
        todoService.createTodo("content", 1L);

        // then
        // 동작의 결과와 우리의 의도가 동일한지 검증
        Mockito.verify(todoRepository, Mockito.times(1)).save(Mockito.any(Todo.class));


    }

    @Test
    public void createTodoTest_When_MemberDoesNotExist() {

        // given
        // 테스트 할 때 필요한 사전 데이터 세팅
        BDDMockito.given(memberRepository.findById(Mockito.anyLong())).willReturn(null);

        // when & then
        // 테스트 할 동작 실행
        Assertions.assertThatThrownBy(() -> {
            // 테스트할 동작 실행
            todoService.createTodo("content", 999999L);
        })
                .hasMessageContaining("존재하지 않는 멤버입니다.")
                .isInstanceOf(Exception.class);

    }
}
