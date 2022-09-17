package com.smg.mundialteams.dto;

import com.smg.mundialteams.domain.Player;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TeamDTO {
    private Long id;
    private String name;
    private String country;
    private List<Player> players;


}
