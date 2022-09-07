package com.smg.mundialteams.service;

import com.smg.mundialteams.domain.Team;
import com.smg.mundialteams.dto.TeamDTO;
import com.smg.mundialteams.exeptions.NoContent;
import com.smg.mundialteams.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeamServiceImp{

    private final TeamRepository teamRepository;

    private static final String NO_CONTENT = "No Content";

    public List<Team> findAll() {
        List<Team> team = this.teamRepository.findAll();
        if(team.isEmpty()) throw  new NoContent(NO_CONTENT);
        return team;
    }

    public Team findById(Long id) {
        Optional<Team> team = this.teamRepository.findById(id);
        if(team.isEmpty()) throw  new NoContent(NO_CONTENT);
        return team.orElse(null);
    }

    public Team save(TeamDTO team) {
        Team team1 = teamRepository.save(new Team(team));
        if (team1.getCountry() == null) throw  new NoContent(NO_CONTENT);
        return team1;
    }

    public Team save(Team team) {
         Team team1 = teamRepository.save(team);
         if(team1.getCountry() == null) throw new NoContent(NO_CONTENT);
        return team1;
    }

    public List<Team> saveAll(List<Team> teams) {
        List<Team> teams1 = teamRepository.saveAll(teams);
        if(teams1.isEmpty()) throw new NoContent(NO_CONTENT);
        return teams1;
    }


    public void delete(Long id) {
        if(id == null)throw new NoContent(NO_CONTENT);
        teamRepository.deleteById(id);
    }
}
