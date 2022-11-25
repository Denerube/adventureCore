package adv.core.advCore.dndcore.models;

import javax.persistence.*;

@Entity(name = "Character")
@Table(name = "characters")
public class DnDCharacterSheetModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column
    private String characterName;



}
