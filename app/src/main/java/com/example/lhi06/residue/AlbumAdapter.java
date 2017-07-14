package com.example.lhi06.residue;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private ArrayList<Album> albumList = new ArrayList<>();
    private final LayoutInflater inflater;
    View view;
    AlbumViewHolder holder;
    private Context context;

    public AlbumAdapter(final Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setListContent(ArrayList<Album> albumList) {
        this.albumList = albumList;
        notifyItemRangeChanged(0, albumList.size());
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(final ViewGroup parent,final int viewType) {
        view = inflater.inflate(R.layout.row_item, parent, false);
        holder = new AlbumViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final AlbumViewHolder holder, final int position) {
        Album listItems = albumList.get(position);
        holder.artistName.setText(listItems.getArtistName());
        holder.albumName.setText(listItems.getCollectionName());
        Picasso.with(context).load(listItems.getArtworkUrl()).into(holder.albumArt);
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView artistName, albumName;
        ImageView albumArt;
        public AlbumViewHolder(final View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            artistName=(TextView)itemView.findViewById(R.id.artist_name);
            albumName =(TextView)itemView.findViewById(R.id.album_name);
            albumArt =(ImageView)itemView.findViewById(R.id.album_art);

        }

        @Override
        public void onClick(View v) {

        }
    }

    public void removeAt(int position) {
        albumList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(0, albumList.size());
    }

}

















//
//    private ArrayList<Album> albumResults;
//    Context mContext;
//
//    private static class ViewHolder {
//        TextView artistName;
//        TextView collectionName;
//        ImageView artworkUrl100;
//    }
//
//    public AlbumAdapter(ArrayList<Album> albums, Context context) {
//        super(context, R.layout.row_item, albums);
//        this.albumResults = albums;
//        this.mContext=context;
//    }
//
//    @Override
//    public void onClick(View v) {
//
//        int position=(Integer) v.getTag();
//        Object object= getItem(position);
//        Album dataModel=(Album)object;
//
//        switch (v.getId())
//        {
//            case R.id.item_info:
//                Snackbar.make(v, "Release date " +dataModel.getFeature(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
//                break;
//        }
//    }

