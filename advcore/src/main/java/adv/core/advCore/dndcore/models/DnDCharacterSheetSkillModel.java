package adv.core.advCore.dndcore.models;

import adv.core.advCore.dndcore.models.keys.DnDCharacterSheetSkillPK;

import javax.persistence.*;

public class DnDCharacterSheetSkillModel {

    @EmbeddedId
    private DnDCharacterSheetSkillPK dnDCharacterSheetSkillPK;

    @ManyToOne
    @MapsId("DnDCharacterSheetId")
    @JoinColumn(name = "characterId")
    private DnDCharacterSheetModel characterSheet;

    @ManyToOne
    @MapsId("DnDAbilityId")
    @JoinColumn(name = "abilityId")
    private DnDAbilityModel ability;

    @Column
    private boolean proficiency;

    @Column
    private int modifier;


}
