package com.example.lhi06.residue;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlbumReviewActivity extends AppCompatActivity {

    @BindView(R.id.textview_album_name) TextView albumNameTextView;
    @BindView(R.id.textview_artist_name) TextView artistNameTextView;
    @BindView(R.id.imageview_album_art) ImageView albumArtworkImageView;
    @BindView(R.id.ratingbar_album_rating) RatingBar reviewRatingBar;
    @BindView(R.id.edittext_written_review) EditText reviewEditText;
    @BindView(R.id.floatingbutton_save_review) FloatingActionButton saveReviewButton;

    private List<AlbumReview> reviews;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_review);
        ButterKnife.bind(this);
        reviews = SaveReviews.loadData(this);

        final Album album = getIntent().getExtras().getParcelable(FindAlbumActivity.ALBUM_EXTRA);
        if (album != null) {
            albumNameTextView.setText(album.getCollectionName());
            artistNameTextView.setText(album.getArtistName());
            Picasso.with(this).load(album.getArtworkUrl()).into(albumArtworkImageView);

            saveReviewButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {
                            reviews.add(new AlbumReview(album, reviewRatingBar.getRating(), reviewEditText.getText().toString()));
                            SaveReviews.saveData(reviews, getApplicationContext());
                        }
                    });
                    finish();
                }
            });
        }
    }

}
