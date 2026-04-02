package com.richard.inventorymanagement.auth.service;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.crypto.DirectDecrypter;
import com.nimbusds.jose.crypto.DirectEncrypter;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWTClaimsSet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Date;

@Service
public class JweService {
    private final byte[] secretKey;

    public JweService(@Value("${api.security.token.secret}") String secret) throws Exception{
        this.secretKey = Arrays.copyOf(secret.getBytes(StandardCharsets.UTF_8), 32);
    }

    public String generateToken(UserDetails user) throws Exception {
        //Define a Header do token
        JWEHeader header = new JWEHeader(JWEAlgorithm.DIR, EncryptionMethod.A256GCM);

        //Cria o payload do token
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(user.getUsername())
                .issueTime(new Date())
                .expirationTime(new Date(System.currentTimeMillis() + 3600000)) // Expira em 1 hora
                .build();

        //Cria o token JWE
        EncryptedJWT jwt = new EncryptedJWT(header, claimsSet);

        //Criptografia usando secret key
        DirectEncrypter encrypter = new DirectEncrypter(secretKey);
        jwt.encrypt(encrypter);

        return jwt.serialize();
    }

    public String getUsernameFromToken(String token) throws Exception {
        EncryptedJWT jwt = EncryptedJWT.parse(token);
        DirectDecrypter decrypter = new DirectDecrypter(secretKey);
        jwt.decrypt(decrypter);
        return jwt.getJWTClaimsSet().getSubject();
    }

}
