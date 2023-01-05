package adv.core.advCore.general.controllers;

import adv.core.advCore.general.dto.PlayerDTO;
import adv.core.advCore.general.models.PlayerModel;
import adv.core.advCore.general.models.UserAccountModel;
import adv.core.advCore.general.services.PlayerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("players")
public class PlayerController {

    @Resource(name = "playerService")
    private PlayerService playerService;

    @GetMapping("/{id}")
    public PlayerModel getPlayerById(@PathVariable Long id){
        return  playerService.getPlayerById(id);
    }
    @GetMapping("/all")
    @PreAuthorize("@securityService.hasRoles(#userAccountModel)")
    public List<PlayerDTO> getPlayerById(
            @AuthenticationPrincipal UserAccountModel userAccountModel
            ){

        List<PlayerDTO> playerDTOList= new ArrayList<>();
        for (PlayerModel player:playerService.getAllPlayers()) {
            playerDTOList.add(PlayerDTO.from(player));
        }
        return playerDTOList;
    }



}
