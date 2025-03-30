package com.example.oope11.models;

public class Match implements SoccerEntity {
    private final String homeTeam;
    private final String awayTeam;
    private final String score;
    private final String competition;
    private final String date;
    private final String venue;

    public Match(String homeTeam, String awayTeam, String score, String competition, String date, String venue) {
        if (homeTeam == null || homeTeam.isEmpty()) {
            throw new IllegalArgumentException("Home team cannot be null or empty");
        }
        if (awayTeam == null || awayTeam.isEmpty()) {
            throw new IllegalArgumentException("Away team cannot be null or empty");
        }
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.score = score;
        this.competition = competition;
        this.date = date;
        this.venue = venue;
    }

    @Override
    public String getName() {
        return homeTeam + " vs " + awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getScore() {
        return score;
    }

    public String getCompetition() {
        return competition;
    }

    public String getDate() {
        return date;
    }

    public String getVenue() {
        return venue;
    }

    @Override
    public String toString() {
        return homeTeam + " " + score + " " + awayTeam + " (" + competition + ")";
    }
}