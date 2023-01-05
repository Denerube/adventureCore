package adv.core.advCore.general.services;

import adv.core.advCore.general.models.UserAccountModel;
import adv.core.advCore.general.models.UserRoleEnum;
import adv.core.advCore.general.repositories.UserAccountRepository;
import adv.core.advCore.general.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class UserManager implements UserDetailsManager {
    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void createUser(UserDetails user) {
        ((UserAccountModel) user).setPassword(passwordEncoder.encode(user.getPassword()));
        if (userRoleRepository.findByUserRoleEnum(UserRoleEnum.ROLE_USER).isPresent()){
            ((UserAccountModel) user).setUserRole(userRoleRepository.findByUserRoleEnum(UserRoleEnum.ROLE_USER).get());
        }
        userAccountRepository.save((UserAccountModel) user);
    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return userAccountRepository.existsByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAccountRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException(
                        MessageFormat.format("username {0} not found",username)
                ));
    }
}
