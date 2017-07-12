package com.example.lhi06.residue.data;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lhi06 on 11/07/2017.
 */

public class ArtistAlbumApiHandler {

    private static final String BASE_API_URL = "https://itunes.apple.com/{trm}";
    private static final String APPEND_ALBUM = "entity=album";
    private static final String APPEND_ARTIST = "attribute=artistTerm";

    public void urlBuilder(final String artist) {
        final ANRequest request = AndroidNetworking.get(BASE_API_URL)
                .addPathParameter("trm", "search?")
                .addQueryParameter("term", artist)
                .addQueryParameter("&entity", "album")
                .addQueryParameter("&attribute", "artistTerm")
                .build();

        request.getAsJSONObject(new JSONObjectRequestListener() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray array = response.getJSONArray("results");
                    String collectionName = array.getJSONObject(0).get("collectionName").toString();
                    Log.i("baba leoni", "onResponse: " + array);
                    Log.i("baba leoni", "onResponse: " + collectionName     );
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(ANError anError) {
                Log.i("lol error","lolol" + anError);
            }
        });
    }
}
