package adv.core.advCore.general.controllers;

import adv.core.advCore.general.dto.LoginDTO;
import adv.core.advCore.general.dto.SignupDTO;
import adv.core.advCore.general.dto.TokenDTO;
import adv.core.advCore.general.models.UserAccountModel;
import adv.core.advCore.general.security.TokenGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.resource.BearerTokenAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {

    @Autowired
    UserDetailsManager userDetailsManager;

    @Autowired
    TokenGenerator tokenGenerator;
    @Autowired
    DaoAuthenticationProvider daoAuthenticationProvider;

    @Autowired
    @Qualifier("jwtRefreshTokenAuthProvider")
    JwtAuthenticationProvider refreshTokenProvider;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody SignupDTO signupDTO){

        if(userDetailsManager.userExists(signupDTO.getUsername())){
            return  ResponseEntity.ok("Username already exists");
        }

        UserAccountModel userAccountModel = new UserAccountModel(signupDTO.getUsername(), signupDTO.getPassword());

        userDetailsManager.createUser(userAccountModel);

        Authentication authentication = UsernamePasswordAuthenticationToken.authenticated(userAccountModel,signupDTO.getPassword(), Collections.EMPTY_LIST);

        return  ResponseEntity.ok(tokenGenerator.createToken(authentication));
    }

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody LoginDTO loginDTO){
        Authentication authentication = daoAuthenticationProvider.authenticate(
                UsernamePasswordAuthenticationToken
                        .unauthenticated(loginDTO.getUsername(),loginDTO.getPassword())
        );
        return ResponseEntity.ok(tokenGenerator.createToken(authentication));
    }

    @PostMapping("/token")
    public ResponseEntity token (@RequestBody TokenDTO tokenDTO){
        Authentication authentication = refreshTokenProvider.authenticate(
                new BearerTokenAuthenticationToken(
                        tokenDTO.getRefreshToken()
                ));

        return ResponseEntity.ok(tokenGenerator.createToken(authentication));
    }

}
