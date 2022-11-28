package adv.core.advCore.dndcore.models;

import javax.persistence.*;

@Entity(name = "DnDRaces")
@Table(name = "dndRaces")
public class DnDRaceModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String RaceName;
}
