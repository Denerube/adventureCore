package adv.core.advCore.dndcore.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "DnDProficiency")
@Table(name = "dndProficiency")
public class DnDProficiencyModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @ManyToMany(mappedBy = "characterSheetProficiencies")
    private Set<DnDCharacterSheetModel> characterSheets = new HashSet<>();



}
