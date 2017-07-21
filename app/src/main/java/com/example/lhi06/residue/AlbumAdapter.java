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

        View rootView;
        TextView artistName, albumName;
        ImageView albumArt;

        AlbumViewHolder(@NonNull final View itemView) {
            super(itemView);
            rootView = itemView.findViewById(R.id.linearLayout_row);
            artistName = (TextView) itemView.findViewById(R.id.artist_name);
            albumName = (TextView) itemView.findViewById(R.id.album_name);
            albumArt = (ImageView) itemView.findViewById(R.id.album_art);

        }
    }

    public void removeAt(@NonNull final int position) {
        albums.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(0, albums.size());
    }

    public interface AlbumClickListener {
        void onClick(@NonNull final Album album);
    }

}
