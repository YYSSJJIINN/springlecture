package com.ohgiraffers.section02.annotation.subsection04.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        String[] beanNames = context.getBeanDefinitionNames();
        for(String beanName : beanNames) {
            System.out.println("콩 이름 : " + beanName);
        }

        PokemonService pokemonService = context.getBean("pokemonServiceResource", PokemonService.class);

        // 이 때 과연 어떤 포켓몬이 공격을 하게 될까?
        // 즉, PokemonService에는 어떤 bean이 주입되었을까?
        pokemonService.pokemonAttack();
    }
}
