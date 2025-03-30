package com.example.oope11.iterators;

import com.example.oope11.models.Team;
import java.util.List;

public class TeamIterator implements CustomIterator<Team> {
    private final List<Team> teams;
    private int position;

    public TeamIterator(List<Team> teams) {
        this.teams = teams;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < teams.size();
    }

    @Override
    public Team next() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("No more teams to iterate");
        }
        return teams.get(position++);
    }
}