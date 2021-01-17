package com.example.saturdayproject5_teams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.saturdayproject5_teams.model.Team;
import com.example.saturdayproject5_teams.network.GetDataService;
import com.example.saturdayproject5_teams.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progress_bar);
        recyclerView = findViewById(R.id.recycler_view);

        GetDataService getDataService = RetrofitClient.getRetrofit().create(GetDataService.class);
        Call<List<Team>> callTeam = getDataService.getTeam();
        callTeam.enqueue(new Callback<List<Team>>() {
            @Override
            public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {
                List<Team> teamList = response.body();
                if (teamList != null) {
                    OnClickTeamAction onClickTeamAction = new OnClickTeamAction() {
                        @Override
                        public void perform(int position) {
                            Toast.makeText(MainActivity.this, teamList.get(position).toString(), Toast.LENGTH_SHORT).show();
                        }
                    };
                    createRecyclerView(teamList, onClickTeamAction);
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<Team>> call, Throwable t) {
                t.getStackTrace();
            }
        });
    }

    public void createRecyclerView(List<Team> teamList, OnClickTeamAction onClickTeamAction) {
        TeamListAdapter adapter = new TeamListAdapter(teamList, onClickTeamAction);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    public interface OnClickTeamAction {
        void perform(int position);
    }
}