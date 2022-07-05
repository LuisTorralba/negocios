package com.example.springboot.app.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtProvider {

    // Implementamos un logger para ver cual metodo da error en caso de falla
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    //Valores que tenemos en el aplicattion.properties
    //Clave firma, con la cual se comprobara si es un token valido, el token que insresa el usuario
    @Value("${jwt.secret}")
    private String secret;
    //Tiempo de expiración del token, en el properties esta este tiempo en segundos
    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication){
    	//Con Authentication obtenemos los datos del usuario que se ah autentificado los pasaremos a un objeto de la clase UsuarioMain
        String username = authentication.getName();
        System.out.println("Usuario autenticado: "+username);
        return Jwts.builder().setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))//miltiplicamos por mil ya que el tiempo debe ser en milisegundos
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();//Compacta el token para se utilizado en una URL
    }

    //Valida que el token este formado con la palabra secreta,
    //y los datos del usuario que esta autentificandose
    //.getBody() roles que tiene el usuario
    //subject --> Nombre del usuario
    public String getNombreUsuarioDelToken(String token){
        //Claims sus datos usuario como la fecha de caducidad, roles, etc.
    	Claims claims = Jwts.parser()
    			.setSigningKey(secret)//Establece la clave de firma utilizada para verificar cualquier firma digital JWS descubierta.
    			.parseClaimsJws(token)//Analiza la cadena de asignada
    			.getBody();//Devuelve el cuerpo del token JWT, ya sea en un objeto de tipo Claims
    	System.out.println("getNombreUsuarioFromToken: "+claims.getSubject());
    	return claims.getSubject();//Con esto estamos obteniendo el username del token en tipo String
    }

    public Boolean validateToken(String token){
        try {
        	//Valida si el token del usuario tiene la palabra secreta
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e){
            logger.error("Token mal formado");
        }catch (UnsupportedJwtException e){
            logger.error("Token no soportado");
        }catch (ExpiredJwtException e){
            logger.error("Token expirado");
        }catch (IllegalArgumentException e){
            logger.error("Token vacio");
        }catch (SignatureException e){
            logger.error("Fallo con la firma");
        }
        return false;
    }
}
