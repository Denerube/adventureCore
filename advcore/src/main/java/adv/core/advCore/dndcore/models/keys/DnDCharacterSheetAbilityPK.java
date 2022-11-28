package adv.core.advCore.dndcore.models.keys;

import javax.persistence.Column;
import java.io.Serializable;

public class DnDCharacterSheetAbilityPK implements Serializable {
    @Column
    private long DnDCharacterSheetId;
    @Column
    private long DnDAbilityId;
}
