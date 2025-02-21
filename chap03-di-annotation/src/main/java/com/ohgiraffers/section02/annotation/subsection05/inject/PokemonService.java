package com.ohgiraffers.section02.annotation.subsection05.inject;

import com.ohgiraffers.section02.common.Pokemon;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.stereotype.Service;

@Service("pokemonServiceInject")    // 클래스 레벨의 어노테이션
public class PokemonService {

    private final Pokemon pokemon;

    @Inject     // 메서드 레벨의 어노테이션
//    @Named("pikachu")
    public PokemonService(@Named("pikachu")Pokemon pokemon) {   // 파라미터 레벨의 어노테이션
        this.pokemon = pokemon;
    }
    /* @Named 어노테이션은 메서드 레벨 또는 파라미터 레벨 모두 정의 가능하다. */

    public void pokemonAttack() {

        pokemon.attack();
    }
}
