package adv.core.advCore.general.models;

import javax.persistence.*;

@Entity(name = "System")
@Table(name = "systems")
public class SystemModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column
    private String systemName;

}
