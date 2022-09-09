package com.smg.mundialteams.dto;

import com.smg.mundialteams.domain.Player;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlayerDTO {
    public Long id;
    public String name;
    public String country;

    public PlayerDTO (Player player){
        this.setId(player.getId());
        this.setName(player.getName());
        this.setCountry(player.getCountry());

    }
}
