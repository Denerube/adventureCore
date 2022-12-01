package adv.core.advCore.dndcore.models;

import javax.persistence.*;

@Entity(name = "DnDProficiency")
@Table(name = "dndProficiency")
public class DnDProficiencyModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;



}
