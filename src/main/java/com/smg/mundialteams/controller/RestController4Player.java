package com.smg.mundialteams.controller;

import com.smg.mundialteams.domain.Player;
import com.smg.mundialteams.dto.PlayerDTO;
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

    @GetMapping(path = "/{id}")
    public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable Long id){
        return  new ResponseEntity<>(playerServiceImp.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<Player> createNewPlayer(@RequestBody PlayerDTO playerDTO){
        return  new ResponseEntity<>(playerServiceImp.save(playerDTO), HttpStatus.CREATED);
    }

    @PostMapping(path = "/list/")
    public ResponseEntity<List<Player>> createNewPlayer(@RequestBody List<Player> players){
        return  new ResponseEntity<>(playerServiceImp.saveAll(players), HttpStatus.CREATED);
    }

    @PutMapping(path = "/put/{id}")
    public ResponseEntity<Player> putPlayer(@RequestBody PlayerDTO playerDTO, @PathVariable Long id){
        PlayerDTO player = playerServiceImp.findById(id);
        playerServiceImp.logicUpdate(playerDTO, player);

        return  new ResponseEntity<>(playerServiceImp.save(player), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{id}")
    public  ResponseEntity<Player> deleteByID(@PathVariable Long id){
        playerServiceImp.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
