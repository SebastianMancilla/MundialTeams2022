package com.smg.mundialteams.repository;

import com.smg.mundialteams.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {
    @Override
    Optional<Player> findById(Long id);
}
