package adv.core.advCore.general.security;

import adv.core.advCore.general.dto.TokenDTO;
import adv.core.advCore.general.models.UserAccountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component
public class TokenGenerator {

    @Autowired
    JwtEncoder accesTokenEnconder;

    @Autowired
    @Qualifier("jwtRefreshTokenEncoder")
    JwtEncoder refreshtokenEncoder;

    private String createAccestoken(Authentication authentication){
        UserAccountModel userAccountModel = (UserAccountModel) authentication.getPrincipal();
        userAccountModel.setPlayers(null);
        Instant now = Instant.now();
        JwtClaimsSet claimsSetd= JwtClaimsSet
                .builder()
                .issuer("AdvCoreServer")
                .issuedAt(now)
                .expiresAt(now.plus(5, ChronoUnit.MINUTES))
                .subject(userAccountModel.getId().toString())
                .build();

        return accesTokenEnconder.encode(JwtEncoderParameters.from(claimsSetd)).getTokenValue();

    }
    private String createRefreshtoken(Authentication authentication){
        UserAccountModel userAccountModel = (UserAccountModel) authentication.getPrincipal();
        userAccountModel.setPlayers(null);
        Instant now = Instant.now();
        JwtClaimsSet claimsSetd= JwtClaimsSet
                .builder()
                .issuer("AdvCoreServer")
                .issuedAt(now)
                .expiresAt(now.plus(30, ChronoUnit.DAYS))
                .subject(userAccountModel.getId().toString())
                .build();

        return refreshtokenEncoder.encode(JwtEncoderParameters.from(claimsSetd)).getTokenValue();

    }

    public TokenDTO createToken (Authentication authentication){
        if (! (authentication.getPrincipal() instanceof UserAccountModel userAccountModel)){
            throw  new BadCredentialsException(
                    MessageFormat.format("principal {0} is not of UserAccountModel type",authentication.getPrincipal().getClass())
            );
        }
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setUserId(userAccountModel.getId().toString());
        tokenDTO.setAccesToken(createAccestoken((authentication)));

        String refreshToken;

        if (authentication.getCredentials() instanceof Jwt jwt){
            Instant now = Instant.now();
            Instant expiresAt = jwt.getExpiresAt();
            Duration duration = Duration.between(now,expiresAt);
            long daysUntilExpired = duration.toDays();
            if (daysUntilExpired <7){
                refreshToken = createRefreshtoken(authentication);

            }else{
                refreshToken = jwt.getTokenValue();
            }
        }else{
            refreshToken = createRefreshtoken(authentication);
        }
        tokenDTO.setRefreshToken(refreshToken);
        return tokenDTO;

    }


}
