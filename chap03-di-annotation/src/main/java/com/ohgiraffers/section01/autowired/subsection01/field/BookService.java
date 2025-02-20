package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 상위타입인 @Component는 다른 어노테이션들도 쓸 수 있기 때문에 간결함을 위해 꼭 필요한 하위타입 어노테이션을 쓴다.
/* @Service : @Component 어노테이션의 세분화된 하위 타입 중 하나로, 주로 Service-Layer에서 사용한다. */
@Service("bookServiceField")
public class BookService {

    /* 설명. 아래 3가지는 ComponentScan 범위 안에 @Component 계열의 어노테이션이 정의된 클래스가 존재할 때 유효하다:
     *  1. @Service에 의해서 BookService 타입의 bookService 빈이 관리된다.
     *  2. BookDAOImpl에 있는 @Respository에 의해 bookDAOImpl 빈이 관리된다(동시에 BookDAO 타입이기도 하다).
     *  3. @Autowired에 의해서 BookDAO 타입의 빈이 BookService의 필드인 bookDAO 필드에 주입(=대입)된다.
     * */

    /* 목차. 1. 필드 주입
     * ComponentScan 범위 내에서 bean으로 등록된 BookDAO 타입을 찾아서 의존성을 주입해줌.
     * 이 때, 다형성이 적용되어 실제로는 BookDAOImpl을 찾아가게 됨.
     * */
    @Autowired
    private BookDAO bookDAO;

    public List<BookDTO> selectAllBooks() {

        // null값인 bookDAO에 .을 붙이면 NullPointerException 발생
        return bookDAO.selectBookList();
    }

    public BookDTO searchBookBySequence(int sequence) {

        return bookDAO.selectBookById(sequence);
    }
}
