package com.example.lpiem.retrofit;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonAPI {

    @GET("/api/v2/pokemon/{id}")
    Call<Pokemon> getPokemonById(
            @Path("id") int id
    );
}
