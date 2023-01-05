package adv.core.advCore.general.models;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Entity(name = "advUser")
@Table(name = "advUsers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountModel implements UserDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NonNull
    private String username;
    @Column
    @NonNull
    private String password;

    @Column
    @NonNull
    private Boolean expired=false;

    @Column
    @NonNull
    private Boolean locked=false;

    @Column
    @NonNull
    private Boolean expiredCredentials=false;

    @Column
    @NonNull
    private Boolean enabled=true;


    @ManyToOne
    @JoinColumn(name = "userRoleId")
    private UserRoleModel userRole;


    @OneToMany(mappedBy = "user")
    private Set<PlayerModel> players;

    public UserAccountModel(String username, String password) {
        this.username = username;
        this.password = password;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(this.userRole);
    }

    @Override
    public boolean isAccountNonExpired() {
        return !this.expired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !this.expiredCredentials;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
