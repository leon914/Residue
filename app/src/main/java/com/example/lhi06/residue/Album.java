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
