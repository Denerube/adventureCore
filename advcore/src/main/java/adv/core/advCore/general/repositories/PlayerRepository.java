package adv.core.advCore.general.repositories;


import adv.core.advCore.general.models.UserAccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<UserAccountModel,Long> {
}
