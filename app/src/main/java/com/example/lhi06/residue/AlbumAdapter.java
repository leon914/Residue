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

final class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private final Picasso picasso;
    private List<Album> albumList = new ArrayList<>();

    public AlbumAdapter(@NonNull final Picasso picasso) {
        this.picasso = picasso;
    }

    public void setListContent(@NonNull final List<Album> albumList) {
        this.albumList = albumList;
        notifyDataSetChanged();
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, @NonNull final int viewType) {
        return new AlbumViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final AlbumViewHolder holder, @NonNull final int position) {
        final Album listItems = albumList.get(position);
        holder.artistName.setText(listItems.getArtistName());
        holder.albumName.setText(listItems.getCollectionName());
        picasso.load(listItems.getArtworkUrl()).into(holder.albumArt);
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView artistName, albumName;
        ImageView albumArt;

        AlbumViewHolder(@NonNull final View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            artistName = (TextView) itemView.findViewById(R.id.artist_name);
            albumName = (TextView) itemView.findViewById(R.id.album_name);
            albumArt = (ImageView) itemView.findViewById(R.id.album_art);

        }

        @Override
        public void onClick(@NonNull final View v) {

        }
    }

    public void removeAt(@NonNull final int position) {
        albumList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(0, albumList.size());
    }

}
