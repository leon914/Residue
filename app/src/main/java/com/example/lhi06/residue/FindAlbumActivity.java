package com.example.lhi06.residue;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class FindAlbumActivity extends AppCompatActivity {

    AlbumAdapter adapter;

    private List<Album> listAlbum = new ArrayList<>();

    @BindView(R.id.recycleView) RecyclerView recyclerView;

    @Override
    protected void onCreate(@NonNull final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_album);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AlbumAdapter(Picasso.with(this));
        // populateRecyclerViewValues():
    }

    private void populateRecyclerViewValues() {
        // TODO: API buidler and Album list Populater
    }
}
