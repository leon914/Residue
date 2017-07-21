package com.example.lhi06.residue;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Album implements Parcelable {

    private String collectionName;
    private String artistName;

    @SerializedName("artworkUrl100")
    private String artworkUrl;

    Album(@NonNull final Parcel in) {
        collectionName = in.readString();
        artistName = in.readString();
        artworkUrl = in.readString();
    }

    public Album(@NonNull final String collectionName, @NonNull final String artistName, @NonNull final String artworkUrl) {
        this.collectionName = collectionName;
        this.artistName = artistName;
        this.artworkUrl = artworkUrl;
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
        return artworkUrl;
    }

    public void setArtworkUrl(@NonNull final String artworkUrl) {
        this.artworkUrl = artworkUrl;
    }

    public void setArtistName(@NonNull final String artistName) {
        this.artistName = artistName;
    }

    public void setCollectionName(@NonNull final String collectionName) {
        this.collectionName = collectionName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull final Parcel dest, final int flags) {
        dest.writeString(collectionName);
        dest.writeString(artistName);
        dest.writeString(artworkUrl);
    }

    public static final Parcelable.Creator<Album> CREATOR = new Parcelable.Creator<Album>() {

        public Album createFromParcel(@NonNull final Parcel in) {
            return new Album(in);
        }

        public Album[] newArray(final int size) {
            return new Album[size];
        }
    };


}
