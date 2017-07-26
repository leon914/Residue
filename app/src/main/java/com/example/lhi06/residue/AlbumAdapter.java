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

final class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private List<Album> albums = new ArrayList<>();
    private AlbumClickListener clickListener;

    void setListContent(@NonNull final List<Album> albums) {
        this.albums = albums;
        notifyDataSetChanged();
    }

    void setAlbumClickListener(@NonNull final AlbumClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        return new AlbumViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final AlbumViewHolder holder, final int position) {
        final Album listItems = albums.get(position);
        holder.artistNameTextView.setText(listItems.getArtistName());
        holder.albumNameTextView.setText(listItems.getCollectionName());
        Picasso.with(holder.albumArtImageView.getContext()).load(listItems.getArtworkUrl()).into(holder.albumArtImageView);

        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (clickListener != null) {
                    clickListener.onClick(albums.get(holder.getAdapterPosition()));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.linearLayout_row) View rootView;
        @BindView(R.id.textview_artist_name) TextView artistNameTextView;
        @BindView(R.id.textview_album_name) TextView albumNameTextView;
        @BindView(R.id.imageview_album_art) ImageView albumArtImageView;

        AlbumViewHolder(@NonNull final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    interface AlbumClickListener {
        void onClick(@NonNull final Album album);
    }

}
