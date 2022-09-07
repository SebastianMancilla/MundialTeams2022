package com.smg.mundialteams.interfaces;

import com.smg.mundialteams.domain.Team;
import com.smg.mundialteams.dto.TeamDTO;

import java.util.List;

public interface ITeamService {
    List<Team>  findAll();
    Team findById(Long id);
    Team save(TeamDTO team);
    Team save(Team team);
    List<Team> saveAll(List<Team> teams);
    void delete(Long id);
}
