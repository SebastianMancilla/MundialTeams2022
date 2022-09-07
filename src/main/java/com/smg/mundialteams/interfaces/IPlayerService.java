package com.smg.mundialteams.interfaces;


import com.smg.mundialteams.domain.Player;

import java.util.List;

public interface IPlayerService{
    List<Player> findAll();
    Player findById(Long id);
    List<Player> saveAll(List<Player> players);
    Player save (Player player);
    void delete(Long id);
}
