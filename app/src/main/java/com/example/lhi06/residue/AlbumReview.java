package com.example.lhi06.residue;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by lhi06 on 20/07/2017.
 */

public class AlbumReview implements Parcelable{

    private Album album;
    private float rating;
    private String review = "";

    public AlbumReview(@NonNull final Album thisAlbum, final float rating, @NonNull final String review) {
        this.album = thisAlbum;
        this.rating = rating;
        this.review = review;
    }

    protected AlbumReview(Parcel in) {
        album = in.readParcelable(Album.class.getClassLoader());
        rating = in.readFloat();
        review = in.readString();
    }

    @NonNull
    public Album getThisAlbum() {
        return album;
    }

    @NonNull
    public float getRating() {
        return rating;
    }

    @NonNull
    public String getReview() {
        return review;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeParcelable(album, flags);
        dest.writeFloat(rating);
        dest.writeString(review);
    }

    public static final Parcelable.Creator<AlbumReview> CREATOR = new Parcelable.Creator<AlbumReview>() {
        @Override
        public AlbumReview createFromParcel(Parcel in) {
            return new AlbumReview(in);
        }

        @Override
        public AlbumReview[] newArray(int size) {
            return new AlbumReview[size];
        }
    };
}
