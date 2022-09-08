package com.smg.mundialteams.repository;

import com.smg.mundialteams.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository  extends JpaRepository<Team, Long> {
    @Override
    Optional<Team> findById(Long id);
}
