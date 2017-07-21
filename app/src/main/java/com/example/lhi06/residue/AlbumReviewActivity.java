package com.example.lhi06.residue;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlbumReviewActivity extends AppCompatActivity {

    @BindView(R.id.textview_album_name_review) TextView albumName;
    @BindView(R.id.textview_artist_name_review) TextView artistName;
    @BindView(R.id.imageview_album_art_review) ImageView albumArtwork;

    @Override
    protected void onCreate(@NonNull final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_review);
        ButterKnife.bind(this);

        final Album album = getIntent().getExtras().getParcelable(FindAlbumActivity.ALBUM_EXTRA);
        albumName.setText(album.getCollectionName());
        artistName.setText(album.getArtistName());
        Picasso.with(this).load(album.getArtworkUrl()).into(albumArtwork);
    }

}
