package com.example.saturdayproject5_teams.network;

import com.example.saturdayproject5_teams.model.Team;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("/bttmly/nba/master/data/teams.json")
    Call<List<Team>> getTeam();
}
