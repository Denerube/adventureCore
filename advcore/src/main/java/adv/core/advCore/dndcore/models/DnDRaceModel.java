package adv.core.advCore.dndcore.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "DnDRaces")
@Table(name = "dndRaces")
public class DnDRaceModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String raceName;

    @Column
    private String speed;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "DnD_Race_Language",
            joinColumns = { @JoinColumn(name = "dndRace_id") },
            inverseJoinColumns = { @JoinColumn(name = "dndLanguage_id") }
    )
    Set<DnDLanguageModel> raceLanguages = new HashSet<>();


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "DnD_Race_Trait",
            joinColumns = { @JoinColumn(name = "dndRace_id") },
            inverseJoinColumns = { @JoinColumn(name = "dndTrait_id") }
    )
    Set<DnDTraitModel> raceTraits = new HashSet<>();
}
