package com.example.oope11.models;

public class Team implements SoccerEntity {
    private final String name;
    private final String country;
    private final String league;
    private final String stadium;
    private final int foundedYear;

    public Team(String name, String country, String league, String stadium, int foundedYear) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Team name cannot be null or empty");
        }
        this.name = name;
        this.country = country;
        this.league = league;
        this.stadium = stadium;
        this.foundedYear = foundedYear;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getLeague() {
        return league;
    }

    public String getStadium() {
        return stadium;
    }

    public int getFoundedYear() {
        return foundedYear;
    }

    @Override
    public String toString() {
        return name + " (" + country + ")";
    }
}