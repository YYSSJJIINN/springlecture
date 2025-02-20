package com.ohgiraffers.common;

public class MemberDTO {

    private int sequence;               // 회원번호
    private String name;                // 이름
    private String phone;               // 연락처
    private String email;               // 이메일
    private Account personalAccount;    // 개인계좌

    public MemberDTO() {
    }

    public MemberDTO(int sequence, String name, String phone, String email, Account personalAccount) {

        System.out.println("MemberDTO의 모든 매개변수 있는 생성자 호출됨...");
        this.sequence = sequence;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.personalAccount = personalAccount;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {

        System.out.println("MemberDTO의 setSequence 호출됨...");
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        System.out.println("MemberDTO의 setName 호출됨...");
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {

        System.out.println("MemberDTO의 setPhone 호출됨...");
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        System.out.println("MemberDTO의 setemail 호출됨...");
        this.email = email;
    }

    public Account getPersonalAccount() {
        return personalAccount;
    }

    public void setPersonalAccount(Account personalAccount) {

        System.out.println("MemberDTO의 setPersonalAccount 호출됨...");
        this.personalAccount = personalAccount;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "sequence=" + sequence +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", personalAccount=" + personalAccount +
                '}';
    }
}
