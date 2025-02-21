package com.ohgiraffers.section02.annotation.subsection04.resource;

import com.ohgiraffers.section02.common.Pokemon;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceResource")
public class PokemonService {

    /* @Resource 어노테이션언 Jakarta Annotation API 의존성이 필요하다.
     * @Autowired와 같은 Spring이 지원하는 어노테이션과 다르게 name 속성값으로 의존성을 주입할 수 있다.
     * @Qualifier와 마찬가지로 @Primary보다 우선순위가 높으며,
     * bean 후보군들 중 원하는 bean id를 명시해 하나의 bean만 주입받을 수 있다.
     * */
    @Resource(name = "pikachu")
    private Pokemon pokemon;

    public void pokemonAttack() {

        pokemon.attack();
    }
}
