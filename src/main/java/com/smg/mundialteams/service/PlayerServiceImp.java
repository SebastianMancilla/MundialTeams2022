package com.smg.mundialteams.service;

import com.smg.mundialteams.domain.Player;
import com.smg.mundialteams.exeptions.NoContentExeption;
import com.smg.mundialteams.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerServiceImp   {

    private final PlayerRepository playerRepository;



    public List<Player> findAll() {
        List<Player> players = playerRepository.findAll();
        if(players.isEmpty())throw new NoContentExeption("Sin Contenido");
        return players;
    }


    public Player findById(Long id) {
        return playerRepository.findById(id).orElse(null);
    }


    public List<Player> saveAll(List<Player> players) {
        return playerRepository.saveAll(players);
    }


    public Player save(Player player) {
        return playerRepository.save(player);
    }


    public void delete(Long id) {
        playerRepository.deleteById(id);
    }
}
