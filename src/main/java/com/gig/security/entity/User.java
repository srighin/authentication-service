package com.gig.security.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Document(collection = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;
    @NotBlank
    @Size(max = 15)
    private String username;
    private boolean mfa;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean active;
    private Set<Role> roles;
    private LocalDateTime createdDt;

    public User(String username, String email, String password) {
        this.username =username;
        this.email = email;
        this.password = password;
    }
}
