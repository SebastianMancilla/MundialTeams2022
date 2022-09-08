package com.smg.mundialteams.service;

import com.smg.mundialteams.domain.Team;
import com.smg.mundialteams.dto.TeamDTO;
import com.smg.mundialteams.exeptions.BadRequestExep;
import com.smg.mundialteams.exeptions.NoContentExeption;
import com.smg.mundialteams.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeamServiceImp {

    private final TeamRepository teamRepository;

    public List<Team> findAll() {
        List<Team> team = this.teamRepository.findAll();

        if (team.isEmpty()) {
            throw new NoContentExeption("No hay contenido que Mostrar");
        }

        return team;
    }

    public TeamDTO findById(Long id) {
        Optional<Team> team = this.teamRepository.findById(id);

        if (team.isEmpty()){
            throw new BadRequestExep("Id no existente en BD");
        }

        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(team.get().getId());
        teamDTO.setName(team.get().getName());
        teamDTO.setCountry(team.get().getCountry());

        return teamDTO;
    }

    public Team save(TeamDTO teamDTO) {
        if (teamDTO.getName().isEmpty()){
            throw new BadRequestExep("El Atributo 'name' es requerido");
        }
        if(teamDTO.getCountry().isEmpty()){
            throw new BadRequestExep("El atributo 'country' es requerido");
        }
        return teamRepository.save(new Team(teamDTO));
    }


    public List<Team> saveAll(List<Team> teams) {
        if (teams.isEmpty()){
            throw new BadRequestExep("El listado que proporciona esta vacio");
        }

        return teamRepository.saveAll(teams);
    }

    public void logicUpdate(TeamDTO team, TeamDTO dto){
        team.setName(dto.getName());
        team.setCountry(dto.getCountry());
        team.setPlayers(dto.getPlayers());
    }


    public void delete(Long id) {
        Optional<Team> team = teamRepository.findById(id);
        if(team.isEmpty()){
            throw new NoContentExeption("No contennido");
        }
        teamRepository.deleteById(id);
    }
}
