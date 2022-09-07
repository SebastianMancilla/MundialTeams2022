package com.smg.mundialteams.controller;

import com.smg.mundialteams.domain.Player;
import com.smg.mundialteams.service.PlayerServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/player")
@AllArgsConstructor
public class RestController4Player {

    private final PlayerServiceImp playerServiceImp;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Player>> getAllPlayers(){
        List<Player> players = this.playerServiceImp.findAll();
        if(players.isEmpty()){
            return new ResponseEntity<>(this.playerServiceImp.findAll(),HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(this.playerServiceImp.findAll(), HttpStatus.OK);
    }
}
