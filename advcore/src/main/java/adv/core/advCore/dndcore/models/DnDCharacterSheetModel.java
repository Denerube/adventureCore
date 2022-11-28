package adv.core.advCore.dndcore.models;

import adv.core.advCore.general.models.SystemModel;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "DnDCharacter")
@Table(name = "dndCharacters")
public class DnDCharacterSheetModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String characterName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "systemId",referencedColumnName = "id")
    private SystemModel system;

    @OneToMany(mappedBy = "dndClass")
    private Set<DnDCharacterSheetClassModel> classes;


}
