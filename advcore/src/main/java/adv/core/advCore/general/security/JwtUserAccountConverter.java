package adv.core.advCore.general.security;

import adv.core.advCore.general.models.UserAccountModel;
import adv.core.advCore.general.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.Collections;


@Component
public class JwtUserAccountConverter implements Converter<Jwt, UsernamePasswordAuthenticationToken> {

    @Autowired
    UserAccountRepository userAccountRepository;

    @Override
    public UsernamePasswordAuthenticationToken convert(Jwt source) {
        UserAccountModel userAccountModel = new UserAccountModel();
        userAccountModel.setId(Long.parseLong(source.getSubject()));
        userAccountModel= userAccountRepository.findById(userAccountModel.getId()).get();
        userAccountModel.setPlayers(null);
        return new UsernamePasswordAuthenticationToken(userAccountModel,source, Collections.EMPTY_LIST);
    }
}
