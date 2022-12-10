package adv.core.advCore.general.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "advUser")
@Table(name = "advUsers")
@Getter
@Setter
public class UserAccountModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String userName;
    @Column
    private String password;
    @Column
    private String role;
    @OneToMany(mappedBy = "user")
    private Set<PlayerModel> players;


    public UserAccountModel(String userName,String password,String role){
        this.userName = userName;
        this.password = password;
        this.role=role;
    }
}
