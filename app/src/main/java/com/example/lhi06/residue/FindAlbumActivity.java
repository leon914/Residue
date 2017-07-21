package com.example.lhi06.residue;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FindAlbumActivity extends AppCompatActivity {

    public final static String ALBUM_EXTRA = "com.example.lhi06.residue.ALBUM_EXTRA";

    private AlbumAdapter adapter;
    private ItunesService service;


    @BindView(R.id.recycleview_albums_findalbum) RecyclerView recyclerView;
    @BindView(R.id.edittext_request_findalbum) EditText editText;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_album);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AlbumAdapter(Picasso.with(this));
        recyclerView.setAdapter(adapter);
        service = new ItunesService();

        adapter.setAlbumClickListener(new AlbumAdapter.AlbumClickListener() {
            @Override
            public void onClick(@NonNull final Album album) {
                final Intent intent = new Intent(FindAlbumActivity.this, AlbumReviewActivity.class);
                intent.putExtra(ALBUM_EXTRA, album);
                startActivity(intent);
            }
        });

    }

    @OnClick(R.id.search_button)
    public void onSearchClicked() {
        try {
            service.getArtistsAlbums(editText.getText().toString(), new Callback<AlbumSearchResponse>() {
                @Override
                public void onResponse(final Call<AlbumSearchResponse> call, final Response<AlbumSearchResponse> response) {
                    // on background thread
                    adapter.setListContent(response.body().getResults());
                }

                @Override
                public void onFailure(final Call<AlbumSearchResponse> call, final Throwable t) {
                    final Context context = getApplicationContext();
                    Toast.makeText(context, R.string.io_exception, Toast.LENGTH_SHORT).show();
                }
            });

        } catch (IOException e) {
            Toast.makeText(this, R.string.io_exception, Toast.LENGTH_SHORT).show();
        }
    }
}
