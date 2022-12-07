package adv.core.advCore.dndcore.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "DnDLanguage")
@Table(name = "dndLanguage")
public class DnDLanguageModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @ManyToMany(mappedBy = "characterSheetLanguages")
    private Set<DnDCharacterSheetModel> characterSheets = new HashSet<>();

    @ManyToMany(mappedBy = "raceLanguages")
    private Set<DnDRaceModel> races = new HashSet<>();


}
