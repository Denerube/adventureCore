package adv.core.advCore.dndcore.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "DnDFeature")
@Table(name = "dndFeature")
public class DnDFeatureModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    @ManyToMany(mappedBy = "characterSheetFeatures")
    private Set<DnDCharacterSheetModel> characterSheets = new HashSet<>();
}
