package com.ohgiraffers.section01.aop;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberDAO {

    private final Map<Integer, MemberDTO> memberMap;

    public MemberDAO(){
        memberMap = new HashMap<>();
        memberMap.put(123, new MemberDTO(123L, "유관순"));
        memberMap.put(456, new MemberDTO(456L, "홍길동"));
        memberMap.put(789, new MemberDTO(789L, "이순신"));
    }

    public Map<Integer, MemberDTO> selectAllMembers() {

        return memberMap;
    }

    public MemberDTO selectMemberById(int memberId) {

        MemberDTO foundMember = memberMap.get(memberId);

        if(foundMember == null) {   // 없는 회원을 달라고 했을때~
            throw new RuntimeException("MemberDAO의 selectMemberById : 해당하는 id의 회원이 없습니다!");
        }

        return foundMember;
    }
}

