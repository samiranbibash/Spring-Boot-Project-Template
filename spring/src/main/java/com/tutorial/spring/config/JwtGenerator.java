package com.tutorial.spring.config;

import com.tutorial.spring.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.authorization.token.JwtEncodingContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenCustomizer;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator implements OAuth2TokenCustomizer<JwtEncodingContext> {

    @Override
    public void customize(JwtEncodingContext context) {
        if (context.getTokenType().getValue().equals("access_token")) {
            Authentication principal = context.getPrincipal();
            User user = (User) principal.getPrincipal();
            context.getClaims().claims(claims -> {
                claims.put("email", user.getEmail());
                claims.put("role", user.getRole());
            });
        }
    }
}
