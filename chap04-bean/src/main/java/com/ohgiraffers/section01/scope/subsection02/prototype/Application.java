package com.ohgiraffers.section01.scope.subsection02.prototype;

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

        // 어떤 콩들이 있는지 조회
        String[] beanNames = context.getBeanDefinitionNames();
        for(String beanName : beanNames) {
            System.out.println("콩 : " + beanName);
        }

        // 컨텍스트로부터 붕어빵, 딸기우유, 지리산암반수 등의 bean 객체를 반환받는다.
        // 앞 쪽은 넓은 범위인 Product를 사용하고, 뒤쪽은 좁은 범위를 사용하는 것이 다양성이다.
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

        /* 설명.
         *  ShoppingCart bean의 스코프를 prototype으로 설정하면, getBean 메서드를 호출할 때마다
         *  새로운 인스턴스가 생성되어 반환된다.
         *  ======================================================================================================
         *  이 예제에서는 손님 두 명이 각각 쇼핑 카트를 이용해 상품을 담는 상황을 연출하기 위해
         *  ShoppingCart bean을 prototype 스코프로 설정하였다.
         *  그 결과, cart1과 cart2는 서로 다른 인스턴스를 참조하며, 각자의 카트에 담긴 물품도 독립적으로 관리된다.
         *  ======================================================================================================
         *  따라서, cart1과 cart2의 hashCode를 출력해보면 서로 다른 값을 가지는 것을 확인할 수 있다.
         *  이는 각 손님이 독립적인 쇼핑 카트를 사용하는 상황을 적절히 반영한 것이다.
         * */
    }
}