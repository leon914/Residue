package com.example.lhi06.residue;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;

import com.squareup.picasso.Picasso;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FindAlbumActivity extends AppCompatActivity {

    AlbumAdapter adapter;
    ItunesService service;


    @BindView(R.id.recycleView) RecyclerView recyclerView;
    @Nullable @BindView(R.id.request) EditText editText;

    @Override
    protected void onCreate(@NonNull final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_album);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AlbumAdapter(Picasso.with(this));
        recyclerView.setAdapter(adapter);
        service = new ItunesService();

    }

    @OnClick(R.id.search_button)
    public void onSearchClicked() {
        try {
            service.getArtistsAlbums(editText.getText().toString()).enqueue(new Callback<AlbumSearchResponse>() {
                @Override
                public void onResponse(final Call<AlbumSearchResponse> call, final Response<AlbumSearchResponse> response) {
                    // on background thread
                    adapter.setListContent(response.body().getResults());
                }

                @Override
                public void onFailure(final Call<AlbumSearchResponse> call, final Throwable t) {
                    Log.i("LEON", "onFailure:  FAILED" + t);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
