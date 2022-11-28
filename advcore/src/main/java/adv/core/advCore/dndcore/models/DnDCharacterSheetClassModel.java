package adv.core.advCore.dndcore.models;

import adv.core.advCore.dndcore.models.keys.DnDCharacterSheetClassPK;

import javax.persistence.*;

@Entity(name = "DnDCharacterSheetClass")
@Table(name = "dndCharacterSheetClass")
public class DnDCharacterSheetClassModel {

    @EmbeddedId
    private DnDCharacterSheetClassPK dnDCharacterSheetClassPK;

    @ManyToOne
    @MapsId("DnDCharacterSheetId")
    @JoinColumn(name = "characterId")
    private DnDCharacterSheetModel characterSheet;

    @ManyToOne
    @MapsId("DnDClassId")
    @JoinColumn(name = "classId")
    private DnDClass dndClass;

    @Column
    private int classLevel;

}
