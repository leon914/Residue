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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static final String REVIEW_EXTRA = "com.example.lhi06.residue.REVIEW_EXTRA";

    private ReviewAdapter adapter;
    private List<AlbumReview> reviews;

    @BindView(R.id.floatingbutton_addreview) FloatingActionButton addReviewButton;
    @BindView(R.id.recycleview_reviews) RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ReviewAdapter();
        recyclerView.setAdapter(adapter);
        reviews = SaveReviews.loadData(this);
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

}
