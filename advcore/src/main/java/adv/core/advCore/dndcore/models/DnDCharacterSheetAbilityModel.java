package adv.core.advCore.dndcore.models;

import adv.core.advCore.dndcore.models.keys.DnDCharacterSheetAbilityPK;

import javax.persistence.*;

@Entity(name = "DnDCharacterSheetAbility")
@Table(name = "dndCharacterSheetAbility")
public class DnDCharacterSheetAbilityModel {

    @EmbeddedId
    private DnDCharacterSheetAbilityPK dnDCharacterSheetAbilityPK;

    @ManyToOne
    @MapsId("DnDCharacterSheetId")
    @JoinColumn(name = "characterId")
    private DnDCharacterSheetModel characterSheet;

    @ManyToOne
    @MapsId("DnDAbilityId")
    @JoinColumn(name = "abilityId")
    private DnDAbilityModel dndAbility;

    @Column
    private int score;

    @Column
    private int modifier;
}
