package com.ohgiraffers.common;

import java.util.Date;

public class Bread extends Product {

    private Date bakedBate;     // 빵 나온 시간

    public Bread() {
    }

    public Bread(Date bakedBate) {
        this.bakedBate = bakedBate;
    }

    public Bread(String name, int price, Date bakedBate) {
        super(name, price);
        this.bakedBate = bakedBate;
    }

    public Date getBakedBate() {
        return bakedBate;
    }

    public void setBakedBate(Date bakedBate) {
        this.bakedBate = bakedBate;
    }

    @Override
    public String toString() {
        return "Bread{" +
                "bakedBate=" + bakedBate +
                '}';
    }
}
