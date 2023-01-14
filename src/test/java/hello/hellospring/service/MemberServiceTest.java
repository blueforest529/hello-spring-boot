package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("hello");

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
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

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

    @Test
    void findOne() {
    }
}