package com.smg.mundialteams.dto;

import com.smg.mundialteams.domain.Player;
import com.smg.mundialteams.domain.Team;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TeamDTO {
    public Long id;
    public String name;
    public String country;
    public List<Player> players;

    public TeamDTO(Team team) {
        this.setId(team.getId());
        this.setName(team.getName());
        this.setCountry(team.getCountry());
        this.setPlayers(team.getPlayers());
    }

}
