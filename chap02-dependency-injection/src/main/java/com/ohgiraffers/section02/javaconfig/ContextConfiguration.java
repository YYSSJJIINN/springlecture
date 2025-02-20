package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.MemberDTO;
import com.ohgiraffers.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean("account")
    public Account accountGenerator() {

        System.out.println("accountGenerator 동작함...");
        return new PersonalAccount(81, "01039268125707");
    }

    @Bean("member")
    public MemberDTO memberGenerator() {

        System.out.println("memberGenerator() 동작함...");

        /* 1. 생성자 주입 방식
         * accountGenerator 메서드를 호출하면 얻게되는 반환값인 "account" bean을
         * MemberDTO의 생성자 매개변수로 전달하여 의존성을 주입하기 때문에
         * 생성자 주입 방식이라고 부름.
         * */
//        return new MemberDTO(1, "홍길동",
//                "010-1234-5678", "hong.gildong@gmail.com", accountGenerator());

        /* 2. setter 주입 방식
         * 빈(empty) MemberDTO 객체를 기본생성자를 호출하여 생성한 후
         * setter 메서드를 이용해 각각의 필드를 초기화 시킨다.
         * 이 때, 마지막 5번째 필드는 "account" bean을 의존하고 있기 때문에
         * setter 메서드를 호출해 의존성을 주입받았다고하여 setter 주입 방식이라 부른다.*/
        MemberDTO member = new MemberDTO();

        member.setSequence(1);
        member.setName("홍길동");
        member.setPhone("010-1234-5678");
        member.setEmail("hong.gildong@gmail.com");
        member.setPersonalAccount(accountGenerator());

        return member;
    }
}

