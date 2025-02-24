package com.ohgiraffers.section01.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        // 커피콩 유무를 뒤지는 부분은 com.ohgiraffers.section01.aop에 들어와있는 파일들이다.
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section01.aop");

        System.out.println("---------- memberService bean 취득 ----------");
        MemberService memberService = context.getBean("memberService", MemberService.class);

        System.out.println("---------- selectAllMembers 호출 ----------");
        System.out.println(memberService.selectAllMembers());

        System.out.println("---------- selectMemberById 호출 ----------");
        System.out.println(memberService.selectMemberById(456));
        System.out.println(memberService.selectMemberById(777));    // 오류가 뜨는 이유는 목차2번에 해당한다.
    }
}
