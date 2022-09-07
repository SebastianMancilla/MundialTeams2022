package com.smg.mundialteams.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "player")
public class Player implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String country;

    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

}