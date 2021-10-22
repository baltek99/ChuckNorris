package com.dojo.chucknorris.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AppUser {

    @GeneratedValue
    @Id
    private Long id;

    private String username;

    private String password;

//    @ElementCollection(targetClass = UserRoleEnum.class)
//    @Enumerated(EnumType.STRING)
//    private Set<UserRoleEnum> roles;

    @ManyToMany
    private Set<UserRole> roles;

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
