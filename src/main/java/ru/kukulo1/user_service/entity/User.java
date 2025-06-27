package ru.kukulo1.user_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Size(min = 5, max = 255, message = "Username must be 5-255 characters long")
    @Column(nullable = false)
    @Setter
    private String username;
    @Size(min = 5, max = 255, message = "Password must be 5-255 characters long")
    @Column(nullable = false)
    @Setter
    private String password;
    @Transient
    @Getter
    @Setter
    private String passwordConfirm;
    @ManyToMany(fetch = FetchType.EAGER)
    @Getter
    @Setter
    private Set<Role> roles;

    public User() {}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
