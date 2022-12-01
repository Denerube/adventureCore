package adv.core.advCore.dndcore.models;


import javax.persistence.*;

@Entity(name = "DnDFeature")
@Table(name = "dndFeature")
public class DnDFeatureModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;
}
