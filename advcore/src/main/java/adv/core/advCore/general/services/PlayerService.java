package adv.core.advCore.general.services;


import adv.core.advCore.general.models.PlayerModel;
import adv.core.advCore.general.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(
            @Qualifier("playerRepository")
            PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public PlayerModel getPlayerById(final Long id){
        return playerRepository.findById(id).get();
    }

    public List<PlayerModel> getAllPlayers(){
        return playerRepository.findAll();
    }
}
