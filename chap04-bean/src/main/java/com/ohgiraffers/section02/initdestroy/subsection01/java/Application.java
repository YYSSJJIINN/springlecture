package com.ohgiraffers.section02.initdestroy.subsection01.java;

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
         *  init 메서드는 bean 객체가 생성될 때(=IoC 컨테이너 초기화 시) 호출되며, 이 시점에 초기화 작업을 수행할 수 있다.
         *  이 메서드는 bean이 컨테이너에 의해 생성되고, 의존성 주입이 완료된 직후에 실행된다.
         *  반면, destroy 메서드는 bean 객체가 소멸될 때(=IoC 컨테이너가 종료될 때) 호출된다.
         *  즉, Spring 애플리케이션이 종료되면서 컨테이너가 소멸되기 전,
         *  bean의 destroy 메서드가 실행되어 정리 작업(cleanup)을 수행한다.
         *  ============================================================================================================
         *  하지만, 애플리케이션이 실행 중인 상태에서 destroy 메서드가 호출되지 않는다.
         *  가비지 컬렉터(GC)가 bean을 메모리에서 제거할 때 destroy 메서드가 실행되는 것이 아니라,
         *  Spring 컨테이너가 명시적으로 종료될 때 이 메서드가 호출된다.
         *  ============================================================================================================
         *  따라서, 컨테이너가 종료되지 않으면 destroy 메서드가 호출되지 않기 때문에,
         *  아래와 같이 강제로 컨테이너를 종료시키는 close() 메서드를 호출하면 bean들이 소멸되면서
         *  destroy 메서드가 실행되는 것을 확인할 수 있다.
         * */
        ((AnnotationConfigApplicationContext) context).close();
    }
}