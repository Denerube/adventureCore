package adv.core.advCore.general.models;

import adv.core.advCore.dndcore.models.DnDCharacterSheetModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Entity(name = "AdvPlayer")
@Table(name = "advPlayers")
@Getter
@Setter
public class PlayerModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String playerName;
    @ManyToOne
    @JoinColumn(name = "userId")
    private UserAccountModel user;

    @OneToMany(mappedBy = "player")
    private Set<DnDCharacterSheetModel> dnDCharacterSheet;



}
