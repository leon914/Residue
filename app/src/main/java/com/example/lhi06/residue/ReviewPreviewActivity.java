package com.example.lhi06.residue;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReviewPreviewActivity extends AppCompatActivity {

    @BindView(R.id.textview_album_name_review) TextView albumNameTextView;
    @BindView(R.id.textview_artist_name_review) TextView artistNameTextView;
    @BindView(R.id.imageview_album_art_review) ImageView albumArtworkTextView;
    @BindView(R.id.ratingbar_album_rating) RatingBar reviewRatingBar;
    @BindView(R.id.edittext_written_review) TextView reviewEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_preview);
        ButterKnife.bind(this);

        final AlbumReview review = getIntent().getExtras().getParcelable(MainActivity.REVIEW_EXTRA);
        if (review != null) {
            albumNameTextView.setText(review.getThisAlbum().getCollectionName());
            artistNameTextView.setText(review.getThisAlbum().getArtistName());
            Picasso.with(this).load(review.getThisAlbum().getArtworkUrl()).into(albumArtworkTextView);
            reviewRatingBar.setRating(review.getRating());
            reviewEditText.setText(review.getReview());
        }
    }
}
