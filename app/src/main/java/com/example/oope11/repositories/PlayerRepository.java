package com.example.oope11.repositories;

import com.example.oope11.models.Player;
import java.util.List;

public class PlayerRepository extends Repository<Player> {
    public List<Player> filterByTeam(String team) {
        return filter(player -> player.getTeam().equalsIgnoreCase(team));
    }

    public List<Player> filterByPosition(String position) {
        return filter(player -> player.getPosition().equalsIgnoreCase(position));
    }
}