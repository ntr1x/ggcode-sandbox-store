package org.ntr1x.common.web.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.*;

@RequiredArgsConstructor
public class GrantedAuthoritiesExtractor implements Converter<Jwt, Collection<GrantedAuthority>> {

    public Collection<GrantedAuthority> convert(Jwt jwt) {

        Map<String, Object> claims = jwt.getClaims();

        String azp = (String) claims.get("azp");

        List<String> clientRoles = Optional
                .of(claims)
                .map(s -> (Map<?, ?>) s.get("resource_access"))
                .map(s -> (Map<?, ?>) s.get(azp))
                .map(s -> {
                    Object roles = s.get("roles");
                    return roles instanceof List<?>
                            ? (List<?>) roles
                            : Collections.emptyList();
                })
                .stream()
                .flatMap(Collection::stream)
                .map(Object::toString)
                .map(s -> "role:" + s.toUpperCase())
                .toList();

        List<String> realmRoles = Optional
                .of(claims)
                .map(s -> (Map<?, ?>) s.get("realm_access"))
                .map(s -> {
                    Object roles = s.get("roles");
                    return roles instanceof List<?>
                            ? (List<?>) roles
                            : Collections.emptyList();
                })
                .stream()
                .flatMap(Collection::stream)
                .map(Object::toString)
                .map(s -> "realm:" + s)
                .toList();

        List<String> scopes = Optional
                .of(claims)
                .map(s -> (String) s.get("scope"))
                .stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .map(String::trim)
                .map(s -> "scope:" + s)
                .toList();

        Collection<String> authorities = new LinkedHashSet<>();
        authorities.addAll(scopes);
        authorities.addAll(realmRoles);
        authorities.addAll(clientRoles);
        return authorities
                .stream()
                .map(SimpleGrantedAuthority::new)
                .map(GrantedAuthority.class::cast)
                .toList();
    }

    @Data
    @NoArgsConstructor
    public static class ResourceAuth {
        @JsonProperty("rsid")
        private String id;
        @JsonProperty("rsname")
        private String name;
        private Map<String, String[]> claims;
    }
}