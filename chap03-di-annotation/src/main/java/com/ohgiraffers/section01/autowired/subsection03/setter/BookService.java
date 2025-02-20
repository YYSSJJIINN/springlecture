package com.ohgiraffers.section01.autowired.subsection03.setter;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 상위타입인 @Component는 다른 어노테이션들도 쓸 수 있기 때문에 간결함을 위해 꼭 필요한 하위타입 어노테이션을 쓴다.
/* @Service : @Component 어노테이션의 세분화된 하위 타입 중 하나로, 주로 Service-Layer에서 사용한다. */
@Service("bookServiceSetter")
public class BookService {

    private  BookDAO bookDAO;

    /* 목차. 3. setter 주입
     * BookDAO 타입의 bean 객체를 setter 메서드의 전달인자로 자동으로 주입해준다. */
    @Autowired
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> selectAllBooks() {

        return bookDAO.selectBookList();
    }

    public BookDTO searchBookBySequence(int sequence) {

        return bookDAO.selectBookById(sequence);
    }
}
