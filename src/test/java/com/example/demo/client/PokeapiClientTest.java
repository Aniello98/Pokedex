package com.example.demo.client;

import com.example.demo.client.bean.PokemonSpecieResponseBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PokeapiClientTest {
    @Autowired
    private PokeapiClient client;

    @Test
    public void test_getPokemonSpecie(){
        PokemonSpecieResponseBean result = client.getPokemonSpecie("mewtwo");
        System.out.println(result);
    }

}