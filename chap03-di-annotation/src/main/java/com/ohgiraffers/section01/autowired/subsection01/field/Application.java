package com.ohgiraffers.section01.autowired.subsection01.field;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        /* 설명. AnnotationConfigApplicationContext 생성자에
         * basePackages 문자열을 전달하면 @ComponentScan 어노테이션을
         * 설정한 클래스 메타 정보가 없더라도 바로 적용시킬 수 있다.
         * */
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        BookService bookService = context.getBean("bookServiceField", BookService.class);

        // 현재 등록된 bean 이름들 확인
        String[] beanNames = context.getBeanDefinitionNames();
        for(String beanName : beanNames) {
            System.out.println("bean 이름 : " + beanName);
        }

        // 전체 도서 목록 조회 후 출력
        bookService.selectAllBooks().forEach(System.out::println);

        // 도서 번호로 도서 검색 후 출력
        System.out.println(bookService.searchBookBySequence(1));
        System.out.println(bookService.searchBookBySequence(2));
    }
}
