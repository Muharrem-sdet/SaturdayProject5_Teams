package com.example.saturdayproject5_teams.model;

public class Team {
    private String teamId;
    private String abbreviation;
    private String teamName;
    private String simpleName;
    private String location;

    public String getTeamId() {
        return teamId;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return teamId + "\n" + abbreviation + "\n" + teamName + "\n" + simpleName + "\n" + location;
    }
}
