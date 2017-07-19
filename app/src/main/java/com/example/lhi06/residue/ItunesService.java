package com.example.lhi06.residue;

import android.support.annotation.NonNull;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

 class ItunesService {

    private static final String BASE_API_URL = "https://itunes.apple.com/";

    private final ItunesApi service;

     ItunesService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ItunesApi.class);
    }

    Call<AlbumSearchResponse> getArtistsAlbums(@NonNull final String artistName) throws IOException {
        return service.getArtistsAlbums(artistName);
    }

    interface ItunesApi {

        @GET("/search?entity=album&attribute=artistTerm")
        Call<AlbumSearchResponse> getArtistsAlbums(@Query("term") String artistName);
    }

}