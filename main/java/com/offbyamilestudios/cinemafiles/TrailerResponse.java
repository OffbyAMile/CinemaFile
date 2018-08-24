package com.offbyamilestudios.cinemafiles;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TrailerResponse {
	@SerializedName("id")
    private int id_trailer;
    @SerializedName( "results" )
    private List<Trailer> results = new ArrayList<>();

    public int getIdTrailer(){
        return id_trailer;
    }

    public void seIdTrailer(int id_trailer){ this.id_trailer = id_trailer; }

    public List<Trailer> getResults() { return results; }

}

