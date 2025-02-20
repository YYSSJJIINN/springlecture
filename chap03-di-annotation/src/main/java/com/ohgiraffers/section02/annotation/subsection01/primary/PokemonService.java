package com.ohgiraffers.section02.annotation.subsection01.primary;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pokemonServicePrimary")
public class PokemonService {

    // Pokemon 유형으로는 다형성 때문에 파이리, 피카츄, 꼬부기 아무나 올 수 있다.
    // 즉, 누가 올지 모른다.
    private final  Pokemon pokemon;

    // 생성자 주입
    @Autowired
    public PokemonService(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}
