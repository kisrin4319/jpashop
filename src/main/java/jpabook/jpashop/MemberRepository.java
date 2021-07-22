package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// DAO와 같은 것이라고 생각하면 된다.
@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Member member){
        em.persist(member);
        return member.getId();
        //커맨드랑 쿼리를 분리해라 라는 원칙
        //왜 Id만 반환 하지? 사이드 이펙트를 일으킬수 있는 커맨드성 이기 때문에 리턴값을 거의 만들지 않고 id정도만 있으면 다시 조회 할 수 있기 때문에
    }

    public Member find(Long id){
        return em.find(Member.class,id);
    }
}
