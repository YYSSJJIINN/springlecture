package com.ohgiraffers.common;

import java.util.List;

public class ShoppingCart {

    private final List<Product> items;

    public ShoppingCart(List<Product> items) {
        this.items = items;
    }

    // 카트에 물품 담는 메서드
    public void addItem(Product item) {
        items.add(item);
    }

    // 카트에 담긴 물품을 출력하는 메서드
    public List<Product> getItems() {
        return items;
    }
}
