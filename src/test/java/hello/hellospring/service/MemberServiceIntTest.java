package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class MemberServiceIntTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("helloC1");

        //what
        Long saveId = memberService.join(member);

        //than
        Member findMember = memberService.findOne(saveId).get();
        assertEquals(member.getName(), findMember.getName()); // true
    }

    @Test
    void 중복회원() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");

        Member member2 = new Member();
        member2.setName("spring2");

        //what
        memberService.join(member1);
//        assertThrows(IllegalStateException.class, () -> memberService.join(member2)); //success
//        assertThrows(NullPointerException.class, () -> memberService.join(member2)); // fail

//        try {
//            memberService.join(member1);
//            memberService.join(member2);
//            fail("예외 발생");
//        } catch (IllegalStateException e) {
//            assertEquals(e.getMessage(), "이미 존재하는 회원입니다   "); // true
////            assertEquals(e.getMessage(), "이미 존재하는 회원입니다   test"); // true
//        }

        //then
    }

}