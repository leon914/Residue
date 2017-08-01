package com.example.lhi06.residue;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by lhi06 on 27/07/2017.
 */

public class Track implements Parcelable {

    private final String trackName;
    private final String previewUrl;

    private Track(@NonNull final Parcel in) {
        trackName = in.readString();
        previewUrl = in.readString();
    }

    public String getTrackName() {
        return trackName;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public static final Creator<Track> CREATOR = new Creator<Track>() {
        @Override
        public Track createFromParcel(@NonNull final Parcel in) {
            return new Track(in);
        }

        @Override
        public Track[] newArray(final int size) {
            return new Track[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull final Parcel dest, final int flags) {
        dest.writeString(trackName);
        dest.writeString(previewUrl);
    }
}
