package com.example.lhi06.residue;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by lhi06 on 27/07/2017.
 */

public class AlbumTrackListResponse {

    private List<Track> results;

    public List<Track> getTracks() {
        return results;
    }

    public void setResults(@NonNull final List<Track> tracks) {
        this.results = tracks;
    }


}
