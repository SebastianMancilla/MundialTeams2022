package com.smg.mundialteams.controller;

import com.smg.mundialteams.domain.Team;
import com.smg.mundialteams.dto.TeamDTO;
import com.smg.mundialteams.exeptions.NoContent;
import com.smg.mundialteams.service.TeamServiceImp;
import lombok.AllArgsConstructor;
import org.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/team")
@AllArgsConstructor
public class RestController4Team {

    private static final Logger log = LoggerFactory.getLogger(RestController4Team.class);
    private final TeamServiceImp teamServiceImp;

    @GetMapping(path = "/")
    public ResponseEntity<List<Team>> getAllTeams() {
        return new ResponseEntity<>(teamServiceImp.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable Long id) {
        return  new ResponseEntity<>(teamServiceImp.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<Team> createNewTeam(@RequestBody TeamDTO body) {
        if (body.country == null) {
            //TODO: Crear para BADREQUEST
            log.debug("No Kaifuku");
        }
        return new ResponseEntity<>(this.teamServiceImp.save(body), HttpStatus.CREATED);
    }

    @PutMapping(path = "/put/{id}")
    public ResponseEntity<Team> putTeam(@RequestBody TeamDTO teamDTO, @PathVariable Long id) {
        Team teamActual = teamServiceImp.findById(id);
        if (teamActual == null) {
            log.debug("No se ha encontrado");
            return new ResponseEntity<>(this.teamServiceImp.findById(id), HttpStatus.NO_CONTENT);
        }
        try {
            teamActual.setName(teamDTO.getName());
            teamActual.setCountry(teamDTO.getCountry());
        } catch (Exception ex) {
            log.debug(ex.getMessage());
        }
        return new ResponseEntity<>(this.teamServiceImp.save(teamActual), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Team> deleteTeam(@PathVariable Long id) {
        this.teamServiceImp.delete(id);
        return new ResponseEntity<>(this.teamServiceImp.findById(id), HttpStatus.NO_CONTENT);
    }


}
