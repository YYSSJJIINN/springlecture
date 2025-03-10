package com.ohgiraffers.section01.scope.subsection01.singleton;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Date;

@Configuration
public class ContextConfiguration {

    @Bean
    public Product carpBread() {
        return new Bread("붕어빵", 1000, new Date());
    }

    @Bean
    public Product milk() {
        return new Beverage("딸기우유", 1700, 350);
    }

    @Bean
    public Product water() {
        return new Beverage("지리산암반수", 3000, 2000);
    }

    @Bean
//    @Scope("")
//    @Scope("singleton")
    @Scope("prototype")
    public ShoppingCart cart() {
        return new ShoppingCart();
    }
}
