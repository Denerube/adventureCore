package adv.core.advCore.dndcore.models;


import javax.persistence.*;

@Entity(name = "DnDExpertise")
@Table(name = "dndExpertise")
public class DnDExpertiseModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;
}
