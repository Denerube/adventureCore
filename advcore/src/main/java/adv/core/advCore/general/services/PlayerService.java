package adv.core.advCore.general.services;


import adv.core.advCore.general.models.UserAccountModel;
import adv.core.advCore.general.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(
            @Qualifier("PlayerRepository")
            PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public UserAccountModel getPlayerById(final Long id){
        return playerRepository.findById(id).get();
    }
}
