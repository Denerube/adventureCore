package adv.core.advCore.dndcore.models;

import adv.core.advCore.dndcore.models.keys.DnDCharacterSheetAbilitiesPK;

import javax.persistence.*;

public class DnDCharacterSheetAbilityModel {

    @EmbeddedId
    private DnDCharacterSheetAbilitiesPK dnDCharacterSheetAbilitiesPK;

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
