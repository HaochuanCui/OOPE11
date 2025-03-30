package com.example.oope11.models;

public class Player implements SoccerEntity {
    private final String name;
    private final int age;
    private final String nationality;
    private final String position;
    private final String team;
    private final int number;

    public Player(String name, int age, String nationality, String position, String team, int number) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Player name cannot be null or empty");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("Player age must be positive");
        }
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.position = position;
        this.team = team;
        this.number = number;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public String getPosition() {
        return position;
    }

    public String getTeam() {
        return team;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return name + " (" + position + ") - " + team;
    }
}