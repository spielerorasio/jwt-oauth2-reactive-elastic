package com.orasio.jwt.elastic.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Document(indexName = "jwt_users", type = "user")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApplicationUser implements UserDetails {
    @Id
    private String id;

    @Setter
    @Getter
    @Field(type = FieldType.Keyword)
    private String username;

    @Getter
    @Field(type = FieldType.Keyword)
    private String password;

    @Getter
    @Setter
    private boolean enabled;

    @Getter
    @Setter
    private List<Role> roles;

    public ApplicationUser(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }


}
