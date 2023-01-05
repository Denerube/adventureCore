package adv.core.advCore.general.dto;

import adv.core.advCore.general.models.PlayerModel;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PlayerDTO {
    private String id;
    private String playerName;


    public static PlayerDTO from(PlayerModel playerModel){
        return builder()
                .id(playerModel.getId().toString())
                .playerName(playerModel.getPlayerName())
                .build();
    }

}
