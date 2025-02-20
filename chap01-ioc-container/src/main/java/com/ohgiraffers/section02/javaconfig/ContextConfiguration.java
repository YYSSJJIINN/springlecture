package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* @Configuration
 * 해당 어노테이션이 정의된 클래스가 IoC 컨테이너가 관리할 bean을 생성하는 클래스임을 의미한다.
 * bean의 이름을 별도로 지정하지 않으면 해당 클래스의 첫 글자를 소문자로 취하여 자동 설정된다.
 * */
// class-level의 어노테이션
@Configuration("configurationSection02")
public class ContextConfiguration {
    // ContextConfiguration는 곧 콩이될 몸. 콩아이콘이 달려있는건 콩으로 관리하겠다는 뜻이기 때문.
    // 인스턴스 생성가능한 존재다.

    /* @Bean :
     * 해당 어노테이션이 정의된 메서드의 반환값을 스프링 컨테이너에 bean으로서 등록한다는 의미다.
     *  이름을 별도로 지정하지 않으면 메서드 이름을 bean의 id로 자동설정한다.
     *  @Bean("myName) 또는 @Bean(name = "myName") 과 같이 bean의 id를 설정할 수 있다.
     * */
    // method-level의 어노테이션
    @Bean(name = "member_d")
    // 메서드는 클래스 내부에 정의된다.
    public MemberDTO getMemberD() {      // 반환형이 MemberDTO인 기본생성자 메서드
        return new MemberDTO();     // 이 리턴값이 갖는 bean의 아이디는 getMemberD
    }

    @Bean(name = "member_a")
    // 메서드는 클래스 내부에 정의된다.
    public MemberDTO getMemberA() {      // 반환형이 MemberDTO인 매개변수 있는 메서드
        return new MemberDTO(1, "user01", "pass01", "홍길동");
    }
}
