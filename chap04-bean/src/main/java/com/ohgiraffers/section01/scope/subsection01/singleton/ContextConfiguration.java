package com.ohgiraffers.section01.scope.subsection01.singleton;

import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class ContextConfiguration {

    @Bean
    public Product carpBread() {
        return new Bread("붕어빵", 1000, new Date());
    }
}
