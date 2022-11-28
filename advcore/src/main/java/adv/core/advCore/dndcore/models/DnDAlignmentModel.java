package adv.core.advCore.dndcore.models;


import javax.persistence.*;

@Entity(name = "DnDAlignment")
@Table(name = "dndAlignment")
public class DnDAlignmentModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String AlignmentName;

}
