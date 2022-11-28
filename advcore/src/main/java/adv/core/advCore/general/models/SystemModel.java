package adv.core.advCore.general.models;

import javax.persistence.*;

@Entity(name = "advSystem")
@Table(name = "advSystems")
public class SystemModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String systemName;

}
