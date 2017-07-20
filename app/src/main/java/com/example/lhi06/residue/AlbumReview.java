package com.example.lhi06.residue;

/**
 * Created by lhi06 on 20/07/2017.
 */

public class AlbumReview {

    Album thisAlbum;
    int rating;
    String review = "";

    public AlbumReview(final Album thisAlbum, final int rating, final String review) {
        this.thisAlbum = thisAlbum;
        this.rating = rating;
        this.review = review;
    }

    public Album getThisAlbum() {
        return thisAlbum;
    }

    public void setThisAlbum(final Album thisAlbum) {
        this.thisAlbum = thisAlbum;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(final int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(final String review) {
        this.review = review;
    }
}
