package com.example.lhi06.residue;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lhi06 on 24/07/2017.
 */

final class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {

    private final Picasso picasso;
    private List<AlbumReview> reviews = new ArrayList<>();
    private ReviewClickListener clickListener;

    ReviewAdapter(@NonNull final Picasso picasso) {
        this.picasso = picasso;
    }

    void setListContent(@NonNull final List<AlbumReview> reviews) {
        this.reviews = reviews;
        notifyDataSetChanged();
    }

    void setReviewClickListener(@NonNull final ReviewClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        return new ReviewViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ReviewViewHolder holder, final int position) {
        final AlbumReview review = reviews.get(position);
        holder.artistName.setText(review.getThisAlbum().getArtistName());
        holder.albumName.setText(review.getThisAlbum().getCollectionName());
        picasso.load(review.getThisAlbum().getArtworkUrl()).into(holder.albumArt);

        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (clickListener != null) {
                    clickListener.onClick(reviews.get(holder.getAdapterPosition()));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    class ReviewViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.linearLayout_row) View rootView;
        @BindView(R.id.artist_name) TextView artistName;
        @BindView(R.id.album_name) TextView albumName;
        @BindView(R.id.album_art) ImageView albumArt;

        ReviewViewHolder(@NonNull final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    interface ReviewClickListener {
        void onClick(@NonNull final AlbumReview review);
    }

}

