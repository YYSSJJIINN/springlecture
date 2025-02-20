package com.ohgiraffers.section03.annotationconfig.subsection01.java;

import com.ohgiraffers.common.MemberDAO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;

/* 목차. 0. 설정용 클래스 파일 자체도 bean으로 관리되며, id를 부여할 수 있다.*/
//@Configuration("configurationSection03")

/* 목차. 1. @ComponentScan 어노테이션과 basePackages를 지정해 간편하게 범위를 설정하여
 * @Component 계열의 어노테이션을 스캔해 모두 bean으로 등록해준다.
 * */
// @ComponentScan(basePackages = "com.ohgiraffers")
// 위의 것을 살리면 MemberDAO를 챙겨가기 때문에 콩이름 출렸했을 때 MemberDAO가 있다.

/* 목차. 2. 범위 설정 시, 필터를 적용해 bean을 관리할 수 있다. - excludeFilters */
/* https://docs.spring.io/spring-framework/reference/core/beans/classpath-scanning.html#beans-scanning-filters */
// 어노테이션이 설정된 클래스들을 싹 다 뒤진다.
//@ComponentScan(basePackages = "com.ohgiraffers",
//        excludeFilters = @ComponentScan.Filter(
//        // filter에 exclude를 설정해놓았기 때문에 MemberDAO를 챙겨가지 않는다.
//        // 콩이름 출렸했을 때 MemberDAO가 없다는 뜻
//                /* 2-1. 타입을 지정해서 설정 */
////                type = FilterType.ASSIGNABLE_TYPE,
////                classes = {MemberDAO.class}
//                /* 2-2. 어노테이션 종류로 설정 */
////                type = FilterType.ANNOTATION,
////                classes = {Repository.class}
//                // 혹시 Repository가 달려있는 애들 있으면 걔넨 안챙겨갈거야
//                // 상위 어노테이션으로 @Component를 설정해주면 가져가긴한다.
//        ))

/* 목차. 3. 범위 설정 시, 필터를 적용해 bean을 관리할 수 있다. - includeFilters */
@ComponentScan(basePackages = "com.ohgiraffers",
        includeFilters = @ComponentScan.Filter(
                // 사용 방법은 excludeFilters와 동일하다.
                type = FilterType.ASSIGNABLE_TYPE,
                classes = MemberDAO.class
        ))
public class ContextConfiguration {
}
