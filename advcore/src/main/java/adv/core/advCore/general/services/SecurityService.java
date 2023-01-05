package adv.core.advCore.general.services;


import adv.core.advCore.general.models.UserAccountModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SecurityService {

    @Autowired
    UserManager userManager;

    Authentication authentication;

    public boolean hasRoles(UserAccountModel userAccountModel){
        return true;
//        if (userAccountModel.getUserRole().getUserRoleEnum() == UserRoleEnum.ROLE_USER){
//            return true;
//        } else{
//            return false;
//        }
    }

}
