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

    private final Picasso picasso;
    private List<Album> albums = new ArrayList<>();
    private AlbumClickListener clickListener;

    AlbumAdapter(@NonNull final Picasso picasso) {
        this.picasso = picasso;
    }

    void setListContent(@NonNull final List<Album> albumList) {
        this.albums = albumList;
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
        holder.artistName.setText(listItems.getArtistName());
        holder.albumName.setText(listItems.getCollectionName());
        picasso.load(listItems.getArtworkUrl()).into(holder.albumArt);

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
        @BindView(R.id.artist_name) TextView artistName;
        @BindView(R.id.album_name) TextView albumName;
        @BindView(R.id.album_art) ImageView albumArt;

        AlbumViewHolder(@NonNull final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    interface AlbumClickListener {
        void onClick(@NonNull final Album album);
    }

}
