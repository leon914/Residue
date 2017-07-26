package com.example.lhi06.residue;

import android.support.annotation.NonNull;

/**
 * Created by lhi06 on 20/07/2017.
 */

public class AlbumReview {

    private Album album;
    private int rating = 0;
    private String review = "";

    public AlbumReview(@NonNull final Album thisAlbum, final int rating, @NonNull final String review) {
        this.album = thisAlbum;
        this.rating = rating;
        this.review = review;
    }

    public Album getThisAlbum() {
        return album;
    }
    
    public int getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }
}
