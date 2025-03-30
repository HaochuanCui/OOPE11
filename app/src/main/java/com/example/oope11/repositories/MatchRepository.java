package com.example.oope11.repositories;

import com.example.oope11.models.Match;
import java.util.List;

public class MatchRepository extends Repository<Match> {
    public List<Match> filterByTeam(String team) {
        return filter(match -> 
            match.getHomeTeam().equalsIgnoreCase(team) || 
            match.getAwayTeam().equalsIgnoreCase(team));
    }

    public List<Match> filterByCompetition(String competition) {
        return filter(match -> match.getCompetition().equalsIgnoreCase(competition));
    }
}