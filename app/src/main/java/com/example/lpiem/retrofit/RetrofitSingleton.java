package com.example.lpiem.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private static PokemonAPI instance = null;
    public final static String BASEURL = "https://pokeapi.co/";
    //private static Retrofit retrofit;

    public static PokemonAPI getInstance(){
        if(instance == null){
            instance = buildInstance();
        }
        return instance;
    }

    private static PokemonAPI buildInstance(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build();
        PokemonAPI pokemonAPI = retrofit.create(PokemonAPI.class);
        return pokemonAPI;
    }

    private RetrofitSingleton(){

    }
}
