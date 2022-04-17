package com.huawei.parkinglot.entity.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(name = "email", nullable = false)
        private String email;

        @Column(name = "password")
        private String password;

        @Column(name = "first_name")
        private String firstName;

        @Column(name = "last_name")
        private String lastName;
        @Column(name = "enabled")

        private boolean enabled;
        @Column(name = "username")
        private String username;
        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))

        private Collection<Role> roles;


}