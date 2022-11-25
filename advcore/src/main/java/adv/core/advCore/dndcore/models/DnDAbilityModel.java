package adv.core.advCore.dndcore.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class DnDAbilityModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column
    private String AbilitieName;
    @Column
    private String AffectedBySkill;
}
