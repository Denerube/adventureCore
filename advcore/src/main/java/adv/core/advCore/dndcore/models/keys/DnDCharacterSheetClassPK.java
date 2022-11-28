package adv.core.advCore.dndcore.models.keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DnDCharacterSheetClassPK implements Serializable {
    @Column
    private long DnDCharacterSheetId;
    @Column
    private long DnDClassId;
}
