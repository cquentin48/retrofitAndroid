package com.example.lpiem.retrofit;



import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Controller implements Callback<List<Change>> {
    static final String BASE_URL = "https://pokeapi.co/";

    public void start() {
        PokemonAPI pokemonAPI = RetrofitSingleton.getInstance();

        Call<Pokemon> callPokemon = pokemonAPI.getPokemonById(1);

        callPokemon.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                response.code();
                if(response.isSuccessful()){
                    Pokemon poke = response.body();
                    Species species = poke.getSpecies();
                    Forms form = poke.getFormListIndexI(0);
                    System.out.println("---]Infos générales[---");
                    System.out.println("Pokémon n° "+poke.getId()+" Nom du pokémon : "+poke.getName());
                    System.out.println("---]Infos sur l'espèce[---");
                    System.out.println("Espèce : "+species.getName()+ " url : "+species.getUrl());
                    System.out.println("---]Infos sur la forme[---");
                    System.out.println("Nom : "+form.getName()+ " url : "+form.getUrl());
                }else{
                    System.out.println("Erreur : "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }

    @Override
    public void onResponse(Call<List<Change>> call, Response<List<Change>> response) {
        if(response.isSuccessful()) {
            List<Change> changesList = response.body();
            changesList.forEach(change -> System.out.println(change.created));
            changesList.forEach(change -> System.out.println(change.branch));
            changesList.forEach(change -> System.out.println(change.owner.getClass()));
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Change>> call, Throwable t) {
        t.printStackTrace();
    }
}