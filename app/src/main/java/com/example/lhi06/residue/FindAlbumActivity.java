package com.example.lhi06.residue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FindAlbumActivity extends AppCompatActivity {

    AlbumAdapter adapter;

    private ArrayList<Album> listAlbum = new ArrayList<>();

    @BindView(R.id.recycleView) RecyclerView recyclerView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_album);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AlbumAdapter(this);
        // populateRecyclerViewValues():
    }

    private void populateRecyclerViewValues() {
        // TODO: API buidler and Album list Populater
    }
}
