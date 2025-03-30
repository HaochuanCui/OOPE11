package com.example.oope11.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.oope11.R;
import com.example.oope11.models.Team;
import java.util.ArrayList;
import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {
    private List<Team> teams;

    public TeamAdapter(List<Team> teams) {
        this.teams = new ArrayList<>(teams);
    }

    public void updateTeams(List<Team> newTeams) {
        this.teams = new ArrayList<>(newTeams);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_team, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Team team = teams.get(position);
        holder.teamNameTextView.setText(team.getName());
        holder.teamCountryTextView.setText(team.getCountry());
        holder.teamLeagueTextView.setText(team.getLeague());
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    static class TeamViewHolder extends RecyclerView.ViewHolder {
        TextView teamNameTextView;
        TextView teamCountryTextView;
        TextView teamLeagueTextView;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            teamNameTextView = itemView.findViewById(R.id.teamNameTextView);
            teamCountryTextView = itemView.findViewById(R.id.teamCountryTextView);
            teamLeagueTextView = itemView.findViewById(R.id.teamLeagueTextView);
        }
    }
}