package adv.core.advCore.general.models;

import javax.persistence.*;

@Entity(name = "User")
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column
    private String UserName;
    @Column
    private String password;
}
