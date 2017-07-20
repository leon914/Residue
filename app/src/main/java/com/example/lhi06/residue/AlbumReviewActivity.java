package com.example.lhi06.residue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlbumReviewActivity extends AppCompatActivity {

    @BindView(R.id.album_name_review) TextView albumName;
    @BindView(R.id.artist_name_review) TextView artistName;
    @BindView(R.id.album_art_review) ImageView albumArtwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_review);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        Album album = (Album) b.getParcelable("album");
        ButterKnife.bind(this);
        albumName.setText(album.getCollectionName());
        artistName.setText(album.getArtistName());
        Picasso.with(this).load(album.getArtworkUrl()).into(albumArtwork);
    }

}
