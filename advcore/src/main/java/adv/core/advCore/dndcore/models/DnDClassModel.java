package adv.core.advCore.dndcore.models;

import adv.core.advCore.general.models.DiceTypes;
import adv.core.advCore.general.models.SystemModel;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "DnDClasses")
@Table(name = "dndClasses")
public class DnDClassModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ClassName;

    @Column
    private int hitDice;

    @Enumerated(EnumType.STRING)
    private DiceTypes hitDieType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "systemId",referencedColumnName = "id")
    private SystemModel system;

    @OneToMany(mappedBy = "characterSheet")
    private Set<DnDCharacterSheetClassModel> characterSheetClass;


}
