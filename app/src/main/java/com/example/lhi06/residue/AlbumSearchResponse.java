package com.example.lhi06.residue;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lhi06 on 19/07/2017.
 */

public class AlbumSearchResponse {

    @SerializedName("results")
    private List<Album> results;

    List<Album> getResults() {
        return results;
    }

    public void setResults(@NonNull final List<Album> albums) {
        this.results = albums;
    }
}
