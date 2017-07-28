package com.example.lhi06.residue;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

    final class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.TrackViewHolder> {

        private List<Track> tracks = new ArrayList<>();
        private TrackClickListener clickListener;

        void setListContent(@NonNull final List<Track> tracks) {
            this.tracks = tracks;
            notifyDataSetChanged();
        }

        void setTrackClickListener(@NonNull final TrackClickListener clickListener) {
            this.clickListener = clickListener;
        }

        @Override
        public TrackViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
            return new TrackViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.track_row_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull final TrackViewHolder holder, final int position) {
            final Track track = tracks.get(position);
            holder.trackName.setText(track.getTrackName());
            holder.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    // TODO: Music Play
//                    if (clickListener != null) {
//                        clickListener.onClick(reviews.get(holder.getAdapterPosition()));
//                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return tracks.size();
        }

        class TrackViewHolder extends RecyclerView.ViewHolder {

            @BindView(R.id.track_element) View rootView;
            @BindView(R.id.textview_track_name) TextView trackName;


            TrackViewHolder(@NonNull final View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }

        interface TrackClickListener {
            void onClick(@NonNull final Track track);
        }

    }

