package com.huang.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
@ConfigurationProperties(prefix = "huang.jwt")//可以在yml文件中配置参数了，前缀为huang.jwt
public class JwtUtils {

	private long expire;
	private String secret;//密钥
	private String header;

	// 生成jwt
	public String generateToken(String username) {

		Date nowDate = new Date();
		Date expireDate = new Date(nowDate.getTime() + 1000 * expire);

		return Jwts.builder()
				.setHeaderParam("typ", "JWT")
				.setSubject(username)
				.setIssuedAt(nowDate)
				.setExpiration(expireDate)// 7天過期
				.signWith(SignatureAlgorithm.HS512, secret)//加密方式
				.compact();
	}

	// 解析jwt
	public Claims getClaimByToken(String jwt) {
		try {
			return Jwts.parser()
					.setSigningKey(secret)
					.parseClaimsJws(jwt)
					.getBody();
		} catch (Exception e) {
			return null;
		}
	}

	// jwt是否过期
	public boolean isTokenExpired(Claims claims) {
		return claims.getExpiration().before(new Date());
	}

}
