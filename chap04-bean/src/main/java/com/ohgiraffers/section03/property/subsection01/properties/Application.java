package com.ohgiraffers.section03.property.subsection01.properties;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(ContextConfiguration.class);

        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        /* 첫 번째 손님이 쇼핑 카트 cart1을 꺼낸다. */
        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);

        /* 첫 번째 손님이 쇼핑 카트 cart1에 붕어빵과 우유를 담는다. */
        cart1.addItem(carpBread);
        cart1.addItem(milk);

        /* cart1에 담긴 물품들을 확인한다. */
        System.out.println("cart1에 담긴 물품들 : " + cart1.getItems());

        System.out.println("----------------------------------------------");

        /* 두 번째 손님이 쇼핑카트 cart2를 꺼낸다. */
        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);

        /* 두 번째 손님이 쇼핑 카트 cart2에 지리산암반수를 담는다. */
        cart2.addItem(water);

        /* cart2에 담긴 물품들을 확인한다. */
        System.out.println("cart2에 담긴 물품들 : " + cart2.getItems());

        /* 두 카트의 hashCode를 출력 및 비교 */
        System.out.println("cart1의 hashcode : " + cart1.hashCode());
        System.out.println("cart2의 hashcode : " + cart2.hashCode());

    }
}