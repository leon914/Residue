package com.example.lhi06.residue;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Album implements Parcelable {

    private final String collectionName;
    private final String artistName;

    @SerializedName("artworkUrl100")
    private final String artworkUrl;
    private final String collectionId;

    private Album(@NonNull final Parcel in) {
        collectionName = in.readString();
        artistName = in.readString();
        artworkUrl = in.readString();
        collectionId = in.readString();
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

    @NonNull
    String getCollectionID() { return collectionId; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull final Parcel dest, final int flags) {
        dest.writeString(collectionName);
        dest.writeString(artistName);
        dest.writeString(artworkUrl);
        dest.writeString(collectionId);
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
