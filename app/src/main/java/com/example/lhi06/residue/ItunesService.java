package com.example.lhi06.residue;

import android.support.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

 class ItunesService {

    private static final String BASE_API_URL = "https://itunes.apple.com/";

    private final ItunesApi service;

     ItunesService() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ItunesApi.class);
    }

    void getArtistsAlbums(@NonNull final String artistName, @NonNull final Callback<AlbumSearchResponse> callback) {
        service.getArtistsAlbums(artistName).enqueue(callback);
    }

    void getAlbumTracks(@NonNull final String collectionId, @NonNull final Callback<AlbumTrackListResponse> callback) {
        service.getAlbumTracks(collectionId).enqueue(callback);
    }

    interface ItunesApi {

        @GET("/search?entity=album&attribute=artistTerm")
        Call<AlbumSearchResponse> getArtistsAlbums(@Query("term") String artistName);

        @GET("/lookup?entity=song")
        Call<AlbumTrackListResponse> getAlbumTracks(@Query("id") String collectionId);
    }

}
//Example GetAlbumTracks Request:
//https://itunes.apple.com/lookup?id=211192863&entity=song
//Example GetArtistsAlbums Request:
//https://itunes.apple.com/search?term=guns and roses&entity=album&attribute=artistTerm
