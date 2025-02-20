package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        /* 설명.
         * AnnotationConfigApplicationContext 클래스를 사용해 ApplicationContext 객체를 생성한다.
         *  생성자에 @Configuration 어노테이션이 정의된 클래스의 메타 정보를 전달인자로 전달하면 된다. */
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        MemberDTO memberD = context.getBean("member_d", MemberDTO.class);
        MemberDTO memberA = context.getBean("member_a", MemberDTO.class);

        System.out.println("IoC 컨테이너에 member_d 콩이 있나? : " + memberD);
        System.out.println("IoC 컨테이너에 member_a 콩이 있나? : " + memberA);
    }
}
