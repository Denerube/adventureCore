package adv.core.advCore.dndcore.models;

import adv.core.advCore.general.models.SystemModel;

import javax.persistence.*;

@Entity(name = "DnDSkills")
@Table(name = "dndSkills")
public class DnDSkillModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String skillName;

    @OneToOne
    @JoinColumn(name = "abilityId",referencedColumnName = "id")
    private DnDAbilityModel basedOnAbility;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "systemId",referencedColumnName = "id")
    private SystemModel system;

}
