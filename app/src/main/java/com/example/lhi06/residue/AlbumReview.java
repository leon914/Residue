package com.example.lhi06.residue;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class AlbumReview implements Parcelable {

    private Album album;
    private float rating;
    private String review = "";
    private List<Track> tracks;


    public AlbumReview(@NonNull final Album thisAlbum, final float rating, @NonNull final String review, @NonNull final List<Track> tracks) {
        this.album = thisAlbum;
        this.rating = rating;
        this.review = review;
        this.tracks = tracks;
    }

    protected AlbumReview(Parcel in) {
        tracks = new ArrayList<>();
        album = in.readParcelable(Album.class.getClassLoader());
        rating = in.readFloat();
        review = in.readString();
        tracks = in.readList(tracks, Track.class.getClassLoader());
    }

    @NonNull
    public Album getThisAlbum() {
        return album;
    }

    public float getRating() {
        return rating;
    }

    @NonNull
    public String getReview() {
        return review;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(final List<Track> tracks) {
        this.tracks = tracks;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull final Parcel dest, final int flags) {
        dest.writeParcelable(album, flags);
        dest.writeFloat(rating);
        dest.writeString(review);
        dest.writeTypedList(tracks);
    }

    public static final Parcelable.Creator<AlbumReview> CREATOR = new Parcelable.Creator<AlbumReview>() {
        @Override
        public AlbumReview createFromParcel(@NonNull final Parcel in) {
            return new AlbumReview(in);
        }

        @Override
        public AlbumReview[] newArray(final int size) {
            return new AlbumReview[size];
        }
    };
}
