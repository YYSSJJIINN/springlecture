package com.ohgiraffers.section01.scope.subsection01.singleton;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/* 필기. Bean Scope:
 *  스프링 bean이 생성될 때 생성되는 인스턴스의 범위를 의미한다. 스프링에서는 다양한 Bean scope를 제공한다.
 *  - Singleton: 하나의 인스턴스만을 생성하고, 모든 bean이 해당 인스턴스를 공유하여 사용한다.
 *  - prototype: 매번 새로운 인스턴스를 생성한다.
 *  - request: HTTP 요청을 처리할 때마다 새로운 인스턴스를 생성하고, 요청 처리가 끝나면 인스턴스를 폐기한다.
 *             웹 애플리케이션 컨텍스트에만 해당된다.
 *  - session: HTTP 세션 당 하나의 인스턴스를 생성하고, 세션이 종료되면 인스턴스를 폐기한다.
 *             웹 애플리케이션 컨텍스트에만 해당된다.
 *  - globalSession: 전역 세션 당 하나의 인스턴스를 생성하고, 전역 세션이 종료되면 인스턴스를 폐기한다.
 *                   포털 애플리케이션 컨텍스트에만 해당된다.
 * */
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
         *  스프링 컨테이너(IoC Container)는 Bean의 기본 스코프를 singleton으로 관리한다.
         *  singleton 스코프를 갖는 Bean은 애플리케이션 컨텍스트 내에서 유일한 인스턴스를 갖는다.
         *  (즉, 애플리케이션 내에서 이 bean을 요청할 때마다 동일한 인스턴스가 반환됨)
         *  =========================================================================================
         *  이 예제에서 손님 두 명이 각각 쇼핑 카트를 이용해 상품을 담았을 때,
         *  singleton으로 관리되는 cart bean은 두 손님이 동일한 카트를 공유하게 된다.
         *  따라서, cart1과 cart2는 동일한 인스턴스를 참조하며, 두 카트에 담긴 물품도 동일하다.
         *  =========================================================================================
         * Note.
         *  만약 카트를 손님별로 독립적으로 사용하고 싶다면, cart 빈을 prototype 스코프로 설정해야 한다.
         *  prototype 스코프를 사용하면 빈을 요청할 때마다 새로운 인스턴스가 생성되어 반환된다.
         * */
    }
}