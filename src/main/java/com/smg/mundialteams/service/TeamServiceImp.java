package com.smg.mundialteams.service;

import com.smg.mundialteams.domain.Team;
import com.smg.mundialteams.dto.TeamDTO;
import com.smg.mundialteams.exeptions.NoContent;
import com.smg.mundialteams.interfaces.ITeamService;
import com.smg.mundialteams.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeamServiceImp{

    private final TeamRepository teamRepository;

    public List<Team> findAll() {
        List<Team> team = this.teamRepository.findAll();
        if(team.isEmpty()) throw  new NoContent("Sin contenido");
        return team;
    }

    public Team findById(Long id) {
        Optional<Team> team = this.teamRepository.findById(id);
        if(team.isEmpty()) throw  new NoContent("Sin contenido");
        return team.orElse(null);
    }

    public Team save(TeamDTO team) {
        return teamRepository.save(new Team(team));
    }

    public Team save(Team team) {
        return teamRepository.save(team);
    }

    public List<Team> saveAll(List<Team> teams) {
        return teamRepository.saveAll(teams);
    }


    public void delete(Long id) {
        teamRepository.deleteById(id);
    }
}
