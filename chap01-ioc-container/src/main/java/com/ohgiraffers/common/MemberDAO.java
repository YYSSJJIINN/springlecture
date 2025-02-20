package com.ohgiraffers.common;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/* 설명. DAO(Data Access Object) :
 *  DAO 클래스는 Repository 계층과 마찬가지로
 *  Java Application과 DBMS를 연동시켜주기 위한 계층의 클래스로 사용된다.
 *
 * 설명. @Repository
 *  DB와 연동하기 위해 사용되는 클래스에 추가하는 어노테이션으로,
 *  이 어노테이션이 정의된 클래스 또한 bean으로써 관리된다.
 *  클래스에 계층의 의미(특별한 기능 수행) 없이 단순한 bean으로 관리하고자 하는 객체는 @Component를 사용한다.
 *  따라서 해당 클래스는 @Component가 아닌 @Repository 어노테이션을 정의한다.
 * */
//@Component
@Repository     // includeFilters 설정이 되어 있다면 @Component 계열의 어노테이션 설정이 없어도 콩으로 관리된다.
// ()괄호치고 이름 안적어줬으므로 디폴트는 클래스명을 소문자로 시작하게 한 것이다.
public class MemberDAO {

    // Map으로 데이터베이스를 모사
    private final Map<Integer, MemberDTO> memberDB;

    public MemberDAO() {

        memberDB = new HashMap<>();

        memberDB.put(1, new MemberDTO(1, "user01", "pass01", "홍길동"));
        memberDB.put(1, new MemberDTO(2, "user02", "pass02", "유관순"));
    }

    public MemberDTO selectMember(int sequence) {
        return memberDB.get(sequence);
    }

    public boolean insertMember(MemberDTO newMember) {

        // 현재 DB의 마지막 PK값 조회
        int autoIncrement = memberDB.size();

        // 새로운 멤버 insert
        memberDB.put(newMember.getSeqeunce(), newMember);

        // 바로 위에서 insert시킨 멤버의 PK값 조회
        int nextAutoIncrement = memberDB.size();

        // 증가된 PK값이 포착된다면 해당 insert 작업은 성공적이라고 판단하여 true를 반환.
        return nextAutoIncrement > autoIncrement ? true : false;
    }
}
