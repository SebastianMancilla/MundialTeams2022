package com.smg.mundialteams.service;

import com.smg.mundialteams.domain.Player;
import com.smg.mundialteams.dto.PlayerDTO;
import com.smg.mundialteams.exeptions.BadRequestExep;
import com.smg.mundialteams.exeptions.NoContentExeption;
import com.smg.mundialteams.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlayerServiceImp   {

    private final PlayerRepository playerRepository;

    public List<Player> findAll() {
        List<Player> players = playerRepository.findAll();

        if(players.isEmpty()){
            throw new NoContentExeption("Sin contenido");
        }
        return players;
    }

    public PlayerDTO findById(Long id) {
        Optional<Player> player = playerRepository.findById(id);

        if(player.isEmpty()){
            throw  new BadRequestExep("ID no existente en la Base de Datos");
        }

        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(player.get().getId());
        playerDTO.setName(player.get().getName());
        playerDTO.setCountry(player.get().getCountry());
//        playerDTO.setTeam(player.get().getTeam().getId());

        return playerDTO;
    }


    public List<Player> saveAll(List<Player> players) {
        if(players.isEmpty()){
            throw  new BadRequestExep("El listado que porporciona esta vacio");
        }
        return playerRepository.saveAll(players);
    }


    public Player save(PlayerDTO playerDTO) {
        if (playerDTO.getName().isEmpty()){
            throw new BadRequestExep("El Atributo 'name' es requerido");
        }
        if(playerDTO.getCountry().isEmpty()){
            throw  new BadRequestExep("El Atributo 'country' es requerido");
        }
        return playerRepository.save(new Player(playerDTO));
    }

    public void logicUpdate(PlayerDTO playerDTO, PlayerDTO dto){
        playerDTO.setName(dto.getName());
        playerDTO.setCountry(dto.getName());
    }



    public void delete(Long id) {
        Optional<Player> player = playerRepository.findById(id);
        if(player.isEmpty()){
            throw  new NoContentExeption("No se encuentra el Id");
        }
        playerRepository.deleteById(id);
    }
}
