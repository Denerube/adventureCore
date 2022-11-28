package adv.core.advCore.general.models;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "advUser")
@Table(name = "advUsers")
public class UserModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String UserName;
    @Column
    private String password;
    @OneToMany(mappedBy = "user")
    private Set<PlayerModel> players;
}
