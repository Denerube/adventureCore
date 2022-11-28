package adv.core.advCore.general.models;

import javax.persistence.*;


@Entity(name = "AdvPlayer")
@Table(name = "advPlayers")
public class PlayerModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String playerName;
    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    private UserModel user;

}
