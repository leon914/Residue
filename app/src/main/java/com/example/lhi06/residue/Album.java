package com.example.lhi06.residue;

public class Album {

    private String collectionName;
    private String artistName;
    private String artworkUrl100;

    public Album(String collectionName, String artistName, String artworkUrl100) {
        this.collectionName = collectionName;
        this.artistName = artistName;
        this.artworkUrl100 = artworkUrl100;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getArtworkUrl() {
        return artworkUrl100;
    }

    public void setArtworkUrl(String artworkUrl100) {
         this.artworkUrl100 = artworkUrl100;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }


}
