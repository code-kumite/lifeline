package com.codekumite.lifeline.dto;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

public class CustomOAuth2User implements OidcUser {
    private OidcUser oauth2User;
    private List<GrantedAuthority> grantedAuthorities;

    public CustomOAuth2User(OidcUser oauth2User, List<GrantedAuthority> grantedAuthorities) {
        this.oauth2User = oauth2User;
        this.grantedAuthorities = grantedAuthorities;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return oauth2User.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getName() {
        return oauth2User.getAttribute("name");
    }

    public String getEmail() {
        return oauth2User.<String>getAttribute("email");
    }

    @Override
    public Map<String, Object> getClaims() {
        return oauth2User.getClaims();
    }

    @Override
    public OidcUserInfo getUserInfo() {
        return oauth2User.getUserInfo();
    }

    @Override
    public OidcIdToken getIdToken() {
        return oauth2User.getIdToken();
    }
}
