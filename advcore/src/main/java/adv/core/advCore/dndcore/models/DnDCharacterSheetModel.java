package adv.core.advCore.dndcore.models;

import adv.core.advCore.general.models.PlayerModel;
import adv.core.advCore.general.models.SystemModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "DnDCharacteSheet")
@Table(name = "dndCharacterSheet")
public class DnDCharacterSheetModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String characterName;

    @Column
    private Boolean Inspiration;

    @Column
    private int experiencePoints;

    @Column
    private int proficiencyBonus;

    @Column
    private int currentHitpoints;

    @Column
    private int maximunHitpoints;

    @Column
    private int currentHitDice;

    @Column
    private int maximumHitDice;

    @Column
    private int CurrentDeathSaveFailures;

    @Column
    private int CurrentDeathSaveSucceses;

    @Column
    private String personalityTraits;

    @Column
    private String ideals;

    @Column
    private String bonds;

    @Column
    private String flaws;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "playerId",referencedColumnName = "id")
    private PlayerModel player;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "systemId",referencedColumnName = "id")
    private SystemModel system;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dndAlignMentId",referencedColumnName = "id")
    private DnDAlignmentModel alignment;

    @OneToMany(mappedBy = "dndClass")
    private Set<DnDCharacterSheetClassModel> classes;

    @OneToMany(mappedBy = "dndSkill")
    private Set<DnDCharacterSheetSkillModel> skills;

    @OneToMany(mappedBy = "dndAbility")
    private Set<DnDCharacterSheetAbilityModel> abilities;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dndraceId",referencedColumnName = "id")
    private DnDRaceModel race;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dndBackgroundId",referencedColumnName = "id")
    private DnDBackground background;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "CharacterSheet_Language",
            joinColumns = { @JoinColumn(name = "dndCharactersheet_id") },
            inverseJoinColumns = { @JoinColumn(name = "dndLanguage_id") }
    )
    Set<DnDLanguageModel> characterSheetLanguages = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "CharacterSheet_Proficiency",
            joinColumns = { @JoinColumn(name = "dndCharactersheet_id") },
            inverseJoinColumns = { @JoinColumn(name = "dndProficiency_id") }
    )
    Set<DnDProficiencyModel> characterSheetProficiencies = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "CharacterSheet_Feature",
            joinColumns = { @JoinColumn(name = "dndCharactersheet_id") },
            inverseJoinColumns = { @JoinColumn(name = "dndFeature_id") }
    )
    Set<DnDFeatureModel> characterSheetFeatures = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "CharacterSheet_Trait",
            joinColumns = { @JoinColumn(name = "dndCharactersheet_id") },
            inverseJoinColumns = { @JoinColumn(name = "dndTrait_id") }
    )
    Set<DnDTraitModel> characterSheetTraits = new HashSet<>();








}
