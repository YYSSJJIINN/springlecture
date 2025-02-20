package com.ohgiraffers.section01.autowired.subsection03.setter;

import com.ohgiraffers.section01.autowired.subsection03.setter.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        // section01에서 살펴본 필드 주입 소스 코드와 거의 비슷하지만, bean 이름은 수정해주자.
        BookService bookService = context.getBean("bookServiceSetter", BookService.class);

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
