package com.example.lhi06.residue;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public static final String REVIEW_EXTRA = "com.example.lhi06.residue.REVIEW_EXTRA";

    @BindView(R.id.floatingbutton_addreview) FloatingActionButton addReviewButton;
    @BindView(R.id.edittext_artist_name) EditText searchField;
    @BindView(R.id.recycleview_reviews) RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final ReviewAdapter adapter = new ReviewAdapter();
        recyclerView.setAdapter(adapter);
        final List<AlbumReview> reviews = SaveReviews.loadData(this);
        adapter.setListContent(reviews);

        adapter.setReviewClickListener(new ReviewAdapter.ReviewClickListener() {
            @Override
            public void onClick(@NonNull final AlbumReview review) {
                final Intent intent = new Intent(MainActivity.this, ReviewPreviewActivity.class);
                intent.putExtra(REVIEW_EXTRA, review);
                startActivity(intent);
            }
        });
        addReviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(@NonNull final View view) {
                startActivity(new Intent(MainActivity.this, FindAlbumActivity.class));
            }
        });

    }

    @OnClick(R.id.search_button)
    public void onSearchClicked(@NonNull final View view) {
        //TODO: Code for searching for reviews done
        
    }

}
