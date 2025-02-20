package com.ohgiraffers.section01.common;

import org.springframework.stereotype.Repository;

import java.util.*;

/* @Repository : @Component 어노테이션의 세분화된 하위 타입 중 하나로, 주로 DataAccess-Layer에서 사용한다. */
@Repository("bookDAO")
public class BookDAOImpl implements BookDAO {

    private Map<Integer, BookDTO> bookList;     // 간이 DB

    /* 기본생성자를 통해 간이 DB 초기화 및 더미 데이터 준비 */
    public BookDAOImpl() {

        bookList = new HashMap<>();

        bookList.put(1, new BookDTO(1, 123456, "자바의 정석", "남궁성", "도우출판", new Date()));
        bookList.put(2, new BookDTO(2, 654321, "칭찬은 고래도 춤추게 한다", "고래", "고래출판", new Date()));
    }

    @Override
    public List<BookDTO> selectBookList() {

        return new ArrayList<>(bookList.values());
    }

    @Override
    public BookDTO selectBookById(int sequence) {

        return bookList.get(sequence);
    }
}
