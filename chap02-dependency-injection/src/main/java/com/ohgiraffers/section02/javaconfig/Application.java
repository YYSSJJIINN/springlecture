package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        /* XML 설정 메타정보를 기반으로 ApplicationContext 객체 생성 */
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        /* 컨테이너가 관리중인 bean 가져오기 */
        MemberDTO member = context.getBean("member", MemberDTO.class);
        System.out.println("IoC 컨테이너에서 member 빈 잘 가져왔나? : " + member);

        /* 추출한 bean 객체의 개인계좌 정보로부터 잔액 확인 */
        System.out.println(member.getPersonalAccount().getBalance());

        System.out.println(member.getPersonalAccount().deposit(100000));    // 10만원 입금
        System.out.println(member.getPersonalAccount().getBalance());    // 잔액 확인

        System.out.println(member.getPersonalAccount().withdraw(14000));    // 14,000 원 출금
        System.out.println(member.getPersonalAccount().getBalance());    // 잔액 확인
    }
}
