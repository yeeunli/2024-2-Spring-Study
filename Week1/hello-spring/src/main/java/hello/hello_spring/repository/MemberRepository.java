package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member); // 회원 저장
    Optional<Member> findById(Long id); // 저장소에서 회원 ID 조회
    Optional<Member> findByName(String name); // 저장소에서 회원 이름 조회
    List<Member> findAll(); // 모든 회원 리스트 반환
}
