package adv.core.advCore.dndcore.models;

import adv.core.advCore.dndcore.models.keys.DnDCharacterSheetSkillPK;

import javax.persistence.*;

@Entity(name = "DnDCharacterSheetSkill")
@Table(name = "dndCharacterSheetSkill")
public class DnDCharacterSheetSkillModel {

    @EmbeddedId
    private DnDCharacterSheetSkillPK dnDCharacterSheetSkillPK;

    @ManyToOne
    @MapsId("DnDCharacterSheetId")
    @JoinColumn(name = "characterId")
    private DnDCharacterSheetModel characterSheet;

    @ManyToOne
    @MapsId("DnDSkillId")
    @JoinColumn(name = "dndSkillId")
    private DnDSkillModel dndSkill;

    @Column
    private boolean proficiency;

    @Column
    private int modifier;


}
