package com.smg.mundialteams.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smg.mundialteams.domain.Team;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
    private Long id;
    private String name;
    private String country;
    private Team team;

    @JsonProperty("team")
    private void unpackNested(Long team2) {
        this.team = new Team();
        team.setId(team2);
    }

}
