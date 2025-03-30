package com.example.oope11.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.oope11.R;
import com.example.oope11.models.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder> {
    private List<Player> players;

    public PlayerAdapter(List<Player> players) {
        this.players = new ArrayList<>(players);
    }

    public void updatePlayers(List<Player> newPlayers) {
        this.players = new ArrayList<>(newPlayers);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_player, parent, false);
        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        Player player = players.get(position);
        holder.playerNameTextView.setText(player.getName());
        holder.playerPositionTextView.setText(player.getPosition());
        holder.playerTeamTextView.setText(player.getTeam());
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    static class PlayerViewHolder extends RecyclerView.ViewHolder {
        TextView playerNameTextView;
        TextView playerPositionTextView;
        TextView playerTeamTextView;

        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            playerNameTextView = itemView.findViewById(R.id.playerNameTextView);
            playerPositionTextView = itemView.findViewById(R.id.playerPositionTextView);
            playerTeamTextView = itemView.findViewById(R.id.playerTeamTextView);
        }
    }
}