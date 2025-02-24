package com.ohgiraffers.section02.reflection;

public class Account {

    private String bankCode;
    private String accNo;
    private String accPwd;
    private int balance;

    public Account() {
    }

    public Account(String bankCode, String accNo, String accPwd, int balance) {
        this.bankCode = bankCode;
        this.accNo = accNo;
        this.accPwd = accPwd;
        this.balance = balance;
    }

    // 금액을 매개변수로 전달받아 잔액을 증가(입금)시키는 메서드
    public String deposit(int money) {

        String msg = "";

        if (money >= 0) {
            this.balance += money;
            msg = money + "원이 입금되었습니다.";
        } else {
            msg = "금액을 잘 못 입력하셨습니다.";
        }
        return msg;
    }

    // 금액을 매개변수로 전달받아 전액을 감소(출금)시키는 메서드
    public String withdraw(int money) {

        String msg = "";

        if (this.balance >= 0) {
            this.balance -= money;
            msg = money + "원이 출금되었습니다.";
        } else {
            msg = "금액을 잘 못 입력하셨습니다.";
        }
        return msg;
    }

    // 현재 잔액을 출력해주는 메서드
    public String getBalance() {

        return this.accNo + " 계좌의 현재 잔액 : " + this.balance + "원.";
    }
}
