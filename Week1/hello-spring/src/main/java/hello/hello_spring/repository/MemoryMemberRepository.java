package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); // store를 해쉬맵을 사용하여 저장소 생성
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // ID를 세팅한다
        store.put(member.getId(), member); // 회원이 기입한 이름을 가져온다
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // store에서 id로 회원 정보를 검색
        // optional과 ofNullable로 정보가 없을 경우 빈 객체를 반환하도록 함; (Optional.empty())
    }

    @Override
    public Optional<Member> findByName(String name) {
        // 스트림 내에서 필터링을 수행
        // store에 저장된 각 Member 객체에 대해 getName() 메서드를 호출
        // 그 값이 메서드에 전달된 name과 같은지 확인
        //일치하는 이름을 가진 Member 객체만 스트림에 남습니다.
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // store에 저장된 모든 회원 정보를 배열리스트로 반환
    }

    public void clearStore() {
        store.clear();
    }
}
