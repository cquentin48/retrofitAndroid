package com.example.lpiem.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pokemon {

    public String getName() {
        return name;
    }

    @SerializedName("name")
    @Expose
    private String name;



    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("species")
    @Expose
    private Species species;

    @SerializedName("forms")
    private List<Forms> formsList;

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public List<Forms> getFormsList() {
        return formsList;
    }

    public Forms getFormListIndexI(int i){
        return formsList.get(i);
    }

    public void setFormsList(List<Forms> formsList) {
        this.formsList = formsList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
