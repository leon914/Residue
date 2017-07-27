package com.example.lhi06.residue;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

final class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {

    private List<AlbumReview> reviews = new ArrayList<>();
    private ReviewClickListener clickListener;

    void setListContent(@NonNull final List<AlbumReview> reviews) {
        this.reviews = reviews;
        notifyDataSetChanged();
    }

    void setReviewClickListener(@NonNull final ReviewClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        return new ReviewViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.review_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ReviewViewHolder holder, final int position) {
        final AlbumReview review = reviews.get(position);
        holder.artistName.setText(review.getThisAlbum().getArtistName());
        holder.albumName.setText(review.getThisAlbum().getCollectionName());
        Picasso.with(holder.albumArt.getContext()).load(review.getThisAlbum().getArtworkUrl()).into(holder.albumArt);

        holder.albumArt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                clickListener.onClick(reviews.get(holder.getAdapterPosition()));
            }
        });

        holder.artistName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                clickListener.onClick(reviews.get(holder.getAdapterPosition()));
            }
        });

        holder.albumName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                clickListener.onClick(reviews.get(holder.getAdapterPosition()));
            }
        });

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                reviews.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                SaveReviews.saveData(reviews, v.getContext());
            }
        });
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    class ReviewViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.review_preview_row) LinearLayout rootView;
        @BindView(R.id.textview_artist_name) TextView artistName;
        @BindView(R.id.textview_album_name) TextView albumName;
        @BindView(R.id.imageview_album_art) ImageView albumArt;
        @BindView(R.id.button_delete) Button deleteButton;

        ReviewViewHolder(@NonNull final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void delete(int position) {
        reviews.remove(position);
        notifyItemRemoved(position);
    }

    interface ReviewClickListener {
        void onClick(@NonNull final AlbumReview review);
    }

}

