package com.example.oope11.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.oope11.R;
import com.example.oope11.models.Match;

import java.util.ArrayList;
import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MatchViewHolder> {
    private List<Match> matches;

    public MatchAdapter(List<Match> matches) {
        this.matches = new ArrayList<>(matches);
    }

    public void updateMatches(List<Match> newMatches) {
        this.matches = new ArrayList<>(newMatches);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_match, parent, false);
        return new MatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        Match match = matches.get(position);
        holder.matchTeamsTextView.setText(match.getName());
        holder.matchScoreTextView.setText("Score: " + match.getScore());
        holder.matchCompetitionTextView.setText("Competition: " + match.getCompetition());
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }

    static class MatchViewHolder extends RecyclerView.ViewHolder {
        TextView matchTeamsTextView;
        TextView matchScoreTextView;
        TextView matchCompetitionTextView;

        public MatchViewHolder(@NonNull View itemView) {
            super(itemView);
            matchTeamsTextView = itemView.findViewById(R.id.matchTeamsTextView);
            matchScoreTextView = itemView.findViewById(R.id.matchScoreTextView);
            matchCompetitionTextView = itemView.findViewById(R.id.matchCompetitionTextView);
        }
    }
}