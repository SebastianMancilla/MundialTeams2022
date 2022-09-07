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

    @GetMapping(path = "/")
    public ResponseEntity<List<Player>> getAllPlayers(){
        return  new ResponseEntity<>(playerServiceImp.findAll(), HttpStatus.OK);
    }
}
