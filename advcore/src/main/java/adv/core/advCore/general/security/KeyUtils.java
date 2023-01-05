package adv.core.advCore.general.security;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Objects;

@Component
@Slf4j
public class KeyUtils {

    @Autowired
    Environment environment;

    @Value("${access-token.private}")
    private String accesTokenPrivateKeyPath;

    @Value("${access-token.public}")
    private String accesTokenPublicKeyPath;

    @Value("${refresh-token.private}")
    private String refreshTokenPrivateKeyPath;

    @Value("${refresh-token.public}")
    private String refreshTokenPublicKeyPath;

    private KeyPair _accesTokenKeyPair;
    private KeyPair _refreshTokenKeyPair;

    private  KeyPair getAccesTokenPair(){
        if (Objects.isNull(_accesTokenKeyPair)){
            _accesTokenKeyPair=getKeyPair(accesTokenPublicKeyPath,accesTokenPrivateKeyPath);
        }
        return _accesTokenKeyPair;
    }
    private  KeyPair getRefreshTokenPair(){
        if (Objects.isNull(_refreshTokenKeyPair)){
            _refreshTokenKeyPair=getKeyPair(refreshTokenPublicKeyPath,refreshTokenPrivateKeyPath);
        }
        return _refreshTokenKeyPair;
    }

    private KeyPair getKeyPair (String publicKeyPath,String privateKeyPath){
        KeyPair keyPair;

        File publicKeyFile=new File(publicKeyPath);
        File privateKeyFile=new File(privateKeyPath);
        if( privateKeyFile.exists() && privateKeyFile.exists() ){
            log.info("loading keys from file: {}, {}", publicKeyPath, privateKeyPath);
            try {
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");

                byte[] publicKeyBytes = Files.readAllBytes(publicKeyFile.toPath());
                EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
                PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

                byte[] privateKeyBytes = Files.readAllBytes(privateKeyFile.toPath());
                PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
                PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

                keyPair = new KeyPair(publicKey, privateKey);
                return keyPair;
            } catch (NoSuchAlgorithmException e) {
                log.info("NoSuchAlgorithmException", e.getMessage());
                throw new RuntimeException(e);
            } catch (IOException e) {
                log.info("IOException", e.getMessage());
                throw new RuntimeException(e);
            } catch (InvalidKeySpecException e) {
                log.info("InvalidKeySpecException", e.getMessage());
                throw new RuntimeException(e);
            }


        }else{
            if (Arrays.stream(environment.getActiveProfiles())
                    .anyMatch(s->s.equals("prod"))){
                throw new RuntimeException("keys not exist");
            }
        }
        //generate keys in dev env, do not do this in prod

        File directory = new File("access-refresh-token-keys");

        if (!directory.exists()){
            directory.mkdirs();
        }

        try{
            //generate keys in memory
            log.info("Generating new public and private keys: {}, {}", publicKeyPath, privateKeyPath);
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();
            //write generated keys to file
            try (FileOutputStream fileOutputStream = new FileOutputStream(publicKeyPath)){
                X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyPair.getPublic().getEncoded());
                fileOutputStream.write(keySpec.getEncoded());
            }
            try (FileOutputStream fileOutputStream = new FileOutputStream(privateKeyPath)){
                PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyPair.getPrivate().getEncoded());
                fileOutputStream.write(keySpec.getEncoded());
            }

        } catch (NoSuchAlgorithmException | IOException e) {

            throw new RuntimeException(e);
        }

        return keyPair;
    };

    public RSAPublicKey getAccesTokenPublicKey(){
        return  (RSAPublicKey) getAccesTokenPair().getPublic();

    };
    public RSAPrivateKey getAccesTokenPrivateKey(){
        return  (RSAPrivateKey) getAccesTokenPair().getPrivate();

    };
    public RSAPublicKey getRefreshTokenPublicKey(){
        return  (RSAPublicKey) getRefreshTokenPair().getPublic();

    };
    public RSAPrivateKey getRefreshTokenPrivateKey(){
        return  (RSAPrivateKey) getRefreshTokenPair().getPrivate();

    };
}
