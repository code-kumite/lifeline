package com.codekumite.lifeline.security;

import com.codekumite.lifeline.dto.CustomOAuth2User;
import com.codekumite.lifeline.entity.Role;
import com.codekumite.lifeline.entity.User;
import com.codekumite.lifeline.repository.RoleRepository;
import com.codekumite.lifeline.repository.UserRepository;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class CustomOAuth2UserService extends OidcUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    CustomOAuth2UserService() {
        System.out.println("CustomOAuth2UserService constructor!");
    }

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("CustomOAuth2UserService is invoked!");
        OidcUser oAuth2User = super.loadUser(userRequest);

        Map<String, Object> attributes = new HashMap<>(oAuth2User.getAttributes());
        String email = (String) attributes.get("email");
        String name = (String) attributes.get("name");

        User user = userRepository.findByEmail(email);
        if (user == null) {
            Role role = roleRepository.findByName("USER");
            user = new User();
            user.setEmail(email);
            user.setName(name);
            user.setPhone("NA");
            user.setPassword("");
            user.setRoles(Arrays.asList(role));

            userRepository.save(user);

        }
        List<Role> roleList = user.getRoles();
        System.out.println(roleList);
        List<GrantedAuthority> authorities =
                AuthorityUtils.createAuthorityList(roleList.stream().map(role -> "ROLE_" + role.getName()).collect(Collectors.toList()));
        CustomOAuth2User customOAuth2User = new CustomOAuth2User(oAuth2User, authorities);
        return customOAuth2User;

    }
}
