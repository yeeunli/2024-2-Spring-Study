package com.example.todo_api.member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    // 회원가입 (생성)
    public void save(Member member) {
        em.persist(member);
    }

    // 로그인 (조회)
    public Member findById(Long id) {
        return em.find(Member.class, id);
    }
}
