package adv.core.advCore.general.repositories;

import adv.core.advCore.general.models.UserAccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccountModel,Long> {
    Optional<UserAccountModel> findByUsername(String username);
    boolean existsByUsername(String username);



}
