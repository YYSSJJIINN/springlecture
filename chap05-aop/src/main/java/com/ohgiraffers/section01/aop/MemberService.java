package com.ohgiraffers.section01.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberService {

    // 멤버 서비스를 호출하기 위해 필드로 가지고 있는다.
    // 이 말은, MemberDAO에게 의존한다는 뜻이다.
    private final MemberDAO memberDAO;

    @Autowired
    public MemberService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    public Map<Integer, MemberDTO> selectAllMembers() {
        System.out.println("MemberService의 selectAllMembers() 동작함...");
        return memberDAO.selectAllMembers();
    }

    public MemberDTO selectMemberById(int memberId) {
        System.out.println("MemberService의 selectMemberById() 동작함...");
        return memberDAO.selectMemberById(memberId);
    }
}
