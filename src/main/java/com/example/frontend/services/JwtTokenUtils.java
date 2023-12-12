package com.example.frontend.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class JwtTokenUtils {
    @Value("mySecretString100000")
    private String secret = UUID.randomUUID().toString();
    //private String secret = UUID.randomUUID().toString();
    //private byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret);
    //private Key signingKey = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());

    @Value("30m")
    private Duration timeLife;

    public String generationToken(UserDetails userDetails){
        //byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret);
        //Key signingKey = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName()); //correct


        Map<String,Object> claims = new HashMap<>();
        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
        claims.put("roles",roles);
        Date date = new Date();
        Date dateExp = new Date(date.getTime() + timeLife.toMillis());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(date)
                .setExpiration(dateExp)
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }

    public String getUserName(String token) {
        //return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();

        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();


    }

    public List<String> getUserRole(String token){
        //return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("roles",List.class);

        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("roles",List.class);
    }
}
