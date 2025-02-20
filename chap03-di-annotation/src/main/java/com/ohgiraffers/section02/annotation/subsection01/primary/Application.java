package com.ohgiraffers.section02.annotation.subsection01.primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        /* 여기서 basePackage 기준으로 Component Scan을 진행했을 때 추출되는 bean은 아래와 같다.
         * - PokemonService
         * - Charmandar
         * - Pikachu
         * - Squirtle
         * */
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        String[] beanNames = context.getBeanDefinitionNames();
        for(String beanName : beanNames) {
            System.out.println("콩 이름 : " + beanName);
        }

        PokemonService pokemonService = context.getBean("pokemonServicePrimary", PokemonService.class);

        // 이 때 과연 어떤 포켓몬이 공격을 하게 될까?
        // 즉, PokemonService에는 어떤 bean이 주입되었을까?
        pokemonService.pokemonAttack();
    }
}
