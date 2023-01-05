package adv.core.advCore.general.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;


@Entity(name = "advRole")
@Table(name = "advRoles")
@Getter
@Setter
@NoArgsConstructor
public class UserRoleModel implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Enumerated(EnumType.STRING)
    private UserRoleEnum userRoleEnum;

    @OneToMany(mappedBy = "userRole")
    private Set<UserAccountModel> user;


    @Override
    public String getAuthority() {
        return this.userRoleEnum.toString();
    }
}
