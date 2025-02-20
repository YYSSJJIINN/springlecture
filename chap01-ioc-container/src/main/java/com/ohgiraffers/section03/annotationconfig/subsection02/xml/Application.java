package com.ohgiraffers.section03.annotationconfig.subsection02.xml;

import com.ohgiraffers.common.MemberDAO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context =
                new GenericXmlApplicationContext("section03/annotationconfig/subsection02/xml/spring-context.xml");

        String[] beanNames = context.getBeanDefinitionNames();

        for(String beanName : beanNames) {
            System.out.println("콩 이름 : " + beanName);
        }

        MemberDAO memberDAO = context.getBean("memberDAO", MemberDAO.class);
        // 위에 부분이 오류가 뜨는데, xml형식에서도 excludeFilter를 사용했으므로 MemberDAO가 제외되는데
        // 제외된 MemberDAO에서 커피콩을 가져오려고 하니 에러가 뜬다.

        System.out.println(memberDAO.selectMember(1));
        System.out.println(memberDAO.insertMember(new MemberDTO(3, "user03", "pass03", "신사임당")));
        System.out.println(memberDAO.selectMember(3));
    }
}
