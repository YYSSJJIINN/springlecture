package com.ohgiraffers.common;

public class PersonalAccount implements Account {

    private final int bankCode;     // 은행 코드
    private final String accNo;     // 계좌 번호
    private int balance;            // 잔액

    // 아래의 매개변수 있는 생성자로 만들어진 결과물은 MemberDTO의 public MemberDTO(Account personalAccount)에게로 간다.
    public PersonalAccount(int bankCode, String accNo) {

        System.out.println("PersonalAccount의 매개변수 있는 생성자 호출됨...");
        this.bankCode = bankCode;
        this.accNo = accNo;
    }

    public int getBankCode() {
        return bankCode;
    }

    public String getAccNo() {
        return accNo;
    }

    // final이 안붙어있으므로 유일하게 set이 올 수 있는 건 balance 잔액이다.
    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String getBalance() {

        return this.accNo + "계좌의 현재 잔액 : " + this.balance + " 원.";
    }

    @Override
    public String deposit(int money) {

        String str = "";

        if(money > 0) {
            this.balance += money;
            str = money + "원이 입금되었습니다.";
        } else {
            str = "유효하지 않은 금액을 입력하셨습니다.";
        }
        return str;
    }

    @Override
    public String withdraw(int money) {     // 내가 출금하고자 하는 어떤 값int money이

        String str = "";

        if(this.balance >= money) {     // 내 계좌잔액과 같거나 보다 적다면
            this.balance -= money;
            str = money + "원이 출금되었습니다.";
        } else {                        // 그렇지 않다면
            str = "잔액이 부족합니다.";
        }
        return str;
    }

    @Override
    public String toString() {
        return "PersonalAccount{" +
                "bankCode=" + bankCode +
                ", accNo='" + accNo + '\'' +
                ", balance=" + balance +
                '}';
    }
}
