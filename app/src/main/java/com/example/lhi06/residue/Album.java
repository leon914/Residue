package com.example.lhi06.residue;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Album {

    @SerializedName("collectionName")
    private String collectionName;

    @SerializedName("artistName")
    private String artistName;

    @SerializedName("artworkUrl100")
    private String artworkUrl100;

    public Album(@NonNull final String collectionName, @NonNull final String artistName, @NonNull final String artworkUrl100) {
        this.collectionName = collectionName;
        this.artistName = artistName;
        this.artworkUrl100 = artworkUrl100;
    }

    @NonNull
    String getCollectionName() {
        return collectionName;
    }

    @NonNull
    String getArtistName() {
        return artistName;
    }

    @NonNull
    String getArtworkUrl() {
        return artworkUrl100;
    }

    public void setArtworkUrl(@NonNull final String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    public void setArtistName(@NonNull final String artistName) {
        this.artistName = artistName;
    }

    public void setCollectionName(@NonNull final String collectionName) {
        this.collectionName = collectionName;
    }


}
