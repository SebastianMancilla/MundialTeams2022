package com.smg.mundialteams.controller;

import com.smg.mundialteams.domain.Team;
import com.smg.mundialteams.dto.TeamDTO;
import com.smg.mundialteams.service.TeamServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/team")
@AllArgsConstructor
public class RestController4Team {

    private final TeamServiceImp teamServiceImp;

    @GetMapping(path = "/")
    public ResponseEntity<List<Team>> getAllTeams() {
        return new ResponseEntity<>(teamServiceImp.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TeamDTO> getTeamById(@PathVariable Long id) {
        return new ResponseEntity<>(teamServiceImp.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<Team> createNewTeam(@RequestBody TeamDTO body) {
        return new ResponseEntity<>(teamServiceImp.save(body), HttpStatus.CREATED);
    }
    @PostMapping(path = "/list/")
    public ResponseEntity<List<Team>> createNewTeams(@RequestBody List<Team> teams){
        return  new ResponseEntity<>(teamServiceImp.saveAll(teams), HttpStatus.CREATED);
    }

    @PutMapping(path = "/put/{id}")
    public ResponseEntity<Team> putTeam(@RequestBody TeamDTO teamDTO, @PathVariable Long id) {
        TeamDTO teamActual = teamServiceImp.findById(id);
        teamServiceImp.logicUpdate(teamActual, teamDTO);
        return new ResponseEntity<>(teamServiceImp.save(teamActual), HttpStatus.CREATED);

    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Team> deleteTeam(@PathVariable Long id) {
        teamServiceImp.delete(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }


}
