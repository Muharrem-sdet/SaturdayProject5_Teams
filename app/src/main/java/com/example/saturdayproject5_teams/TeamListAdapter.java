package com.example.saturdayproject5_teams;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.saturdayproject5_teams.model.Team;

import java.util.List;

public class TeamListAdapter extends RecyclerView.Adapter<TeamListAdapter.TeamViewHolder> {

    private final List<Team> teamList;
    private final MainActivity.OnClickTeamAction onClickTeamAction;

    public TeamListAdapter(List<Team> teamList, MainActivity.OnClickTeamAction onClickTeamAction) {
        this.teamList = teamList;
        this.onClickTeamAction = onClickTeamAction;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_item_view, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        holder.teamName.setText(teamList.get(position).getTeamName());
        holder.location.setText(teamList.get(position).getLocation());
        holder.abbreviation.setText(teamList.get(position).getAbbreviation());
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public class TeamViewHolder extends RecyclerView.ViewHolder {

        private TextView teamName;
        private TextView location;
        private TextView abbreviation;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            teamName = itemView.findViewById(R.id.team_name);
            location = itemView.findViewById(R.id.location);
            abbreviation = itemView.findViewById(R.id.abbreviation);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickTeamAction.perform(getAdapterPosition());
                }
            });
        }
    }
}
