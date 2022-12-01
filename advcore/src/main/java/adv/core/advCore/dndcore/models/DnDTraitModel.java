package adv.core.advCore.dndcore.models;

import javax.persistence.*;

@Entity(name = "DnDTrait")
@Table(name = "dndTrait")
public class DnDTraitModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;
}
