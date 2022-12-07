package adv.core.advCore.dndcore.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "DnDTrait")
@Table(name = "dndTrait")
public class DnDTraitModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @ManyToMany(mappedBy = "raceTraits")
    private Set<DnDRaceModel> races = new HashSet<>();

    @ManyToMany(mappedBy = "characterSheetTraits")
    private Set<DnDCharacterSheetModel> characterSheets = new HashSet<>();
}
