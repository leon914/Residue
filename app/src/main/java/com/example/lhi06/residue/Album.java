package com.example.lhi06.residue;

import android.support.annotation.NonNull;

public class Album {

    private String collectionName;
    private String artistName;
    private String artworkUrl100;

    public Album(@NonNull final String collectionName, @NonNull final String artistName, @NonNull final String artworkUrl100) {
        this.collectionName = collectionName;
        this.artistName = artistName;
        this.artworkUrl100 = artworkUrl100;
    }

    @NonNull
    public String getCollectionName() {
        return collectionName;
    }

    @NonNull
    public String getArtistName() {
        return artistName;
    }

    @NonNull
    public String getArtworkUrl() {
        return artworkUrl100;
    }

    @NonNull
    public void setArtworkUrl(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    @NonNull
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @NonNull
    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }


}
