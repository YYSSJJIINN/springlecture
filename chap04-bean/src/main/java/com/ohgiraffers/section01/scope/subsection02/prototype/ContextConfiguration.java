package com.ohgiraffers.section01.scope.subsection02.prototype;

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
    /* 디폴트값인 "singleton"에서 "prototype"으로 bean scope를 변경 */
    @Scope("prototype")
    public ShoppingCart cart() {
        return new ShoppingCart();
    }
}
