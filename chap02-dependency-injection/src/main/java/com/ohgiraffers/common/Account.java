package com.ohgiraffers.common;

// 인터페이스는 생성자를 가질 수 없다.
public interface Account {

    /* 잔액 조회 */
    String getBalance();

    /* 입금 */
    String deposit(int money);

    /* 출금 */
    String withdraw(int money);
}
