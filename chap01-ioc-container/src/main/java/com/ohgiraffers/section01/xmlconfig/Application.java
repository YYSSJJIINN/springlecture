package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        /* 설명. GenericXmlApplicationContext 클래스를 사용해 ApplicationContext 객체를 생성한다.
        *  생성자에 설정 메타정보가 기술된 XML 파일의 경로를 전달인자로 전달하면 된다.
        * */
        ApplicationContext context =
                new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");

        /* 설명. 크게 세 가지 방법으로 IoC 컨테이너가 관리중인 bean들을 조회해볼 수 있다. */

        // 방법 1: bean의 id를 이용해 bean을 조회
//        MemberDTO member = (MemberDTO) context.getBean("member-d");
//        MemberDTO member = (MemberDTO) context.getBean("member-a");

        // 방법 2: bean의 클래스 메타 정보를 전달하여 가져오는 방법
        /* 컨텍스트가 관리중인 bean 중, 타입이 MemberDTO인 bean이 member-d, member-argu 총 2개라서
        * NoUniqueBeanDefinitionException이 발생함 -> bean 정의가 중독됨.*/
//        MemberDTO member = context.getBean(MemberDTO.class);

        // 방법 3: bean의 클래스 메타정보와 id를 모두 전달하여 가져오는 방법
        MemberDTO member = context.getBean("member-d", MemberDTO.class);

        System.out.println("IoC 컨테이너에 member-d라는 이름의 콩이 있나? : " + member);

    }
}
