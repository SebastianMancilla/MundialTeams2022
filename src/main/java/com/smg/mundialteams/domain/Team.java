package com.smg.mundialteams.domain;

import com.smg.mundialteams.dto.TeamDTO;
import lombok.*;
import net.bytebuddy.utility.nullability.NeverNull;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "team")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Team implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NeverNull
    private String name;

    @NeverNull
    private String country;

    @OneToMany(mappedBy = "team")
    private List<Player> players;

    public Team(TeamDTO team) {
        BeanUtils.copyProperties(team,this);
    }

}
