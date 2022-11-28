package adv.core.advCore.dndcore.models.keys;

import javax.persistence.Column;
import java.io.Serializable;

public class DnDCharacterSheetSkillPK implements Serializable {
    @Column
    private long DnDCharacterSheetId;
    @Column
    private long DnDAbilityId;
}
