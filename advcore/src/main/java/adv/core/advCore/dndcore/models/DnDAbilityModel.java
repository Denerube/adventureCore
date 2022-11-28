package adv.core.advCore.dndcore.models;

import adv.core.advCore.general.models.SystemModel;

import javax.persistence.*;

@Entity(name = "DnDAbilities")
@Table(name = "dndAbilities")
public class DnDAbilityModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String AbilityName;

    @Column
    private String AffectedBySkill;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "systemId",referencedColumnName = "id")
    private SystemModel system;

}
