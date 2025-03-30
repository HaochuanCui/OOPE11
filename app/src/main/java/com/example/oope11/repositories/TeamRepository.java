package com.example.oope11.repositories;

import com.example.oope11.models.Team;
import java.util.List;

public class TeamRepository extends Repository<Team> {
    public List<Team> filterByLeague(String league) {
        return filter(team -> team.getLeague().equalsIgnoreCase(league));
    }
}