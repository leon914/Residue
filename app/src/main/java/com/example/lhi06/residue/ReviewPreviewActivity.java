package com.example.lhi06.residue;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReviewPreviewActivity extends AppCompatActivity {

    private TrackAdapter adapter;

    @BindView(R.id.textview_album_name) TextView albumNameTextView;
    @BindView(R.id.textview_artist_name) TextView artistNameTextView;
    @BindView(R.id.imageview_album_art) ImageView albumArtworkTextView;
    @BindView(R.id.ratingbar_album_rating) RatingBar reviewRatingBar;
    @BindView(R.id.edittext_written_review) TextView reviewEditText;
    @BindView(R.id.recycleview_tracks) RecyclerView recyclerView;
    @BindView(R.id.progress_bar_tracks) ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_preview);
        ButterKnife.bind(this);
        adapter = new TrackAdapter();

        final AlbumReview review = getIntent().getExtras().getParcelable(MainActivity.REVIEW_EXTRA);
        if (review != null) {
            albumNameTextView.setText(review.getThisAlbum().getCollectionName());
            artistNameTextView.setText(review.getThisAlbum().getArtistName());
            Picasso.with(this).load(review.getThisAlbum().getArtworkUrl()).into(albumArtworkTextView);
            reviewRatingBar.setRating(review.getRating());
            reviewEditText.setText(review.getReview());
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(adapter);
            adapter.setListContent(review.getTracks());
            adapter.notifyDataSetChanged();
            recyclerView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        }
    }
}
