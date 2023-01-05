package adv.core.advCore.general.repositories;


import adv.core.advCore.general.models.UserRoleEnum;
import adv.core.advCore.general.models.UserRoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleModel,Long> {
    Optional<UserRoleModel> findByUserRoleEnum (UserRoleEnum UserRoleEnum);
}
