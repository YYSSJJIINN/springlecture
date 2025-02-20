package com.ohgiraffers.section02.annotation.subsection03.collection;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pokemonServiceCollection")
public class PokemonService {

    /* 설명. 같은 타입의 bean이 2개 이상 후보군이 존재할 때,
     * List나 Map 같은 컬렉션 형태로 bean을 주입받을 수 있다.
     * */

    /* 1. List 타입으로 주입 */
    private final List<Pokemon> pokemonList;

    @Autowired
    public PokemonService(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public void pokemonAttack() {
        pokemonList.forEach(Pokemon :: attack);
    }
}
