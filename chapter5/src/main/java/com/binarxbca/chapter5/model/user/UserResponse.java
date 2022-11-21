package com.binarxbca.chapter5.model.user;

import com.binarxbca.chapter5.model.AuditModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse extends AuditModel {
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private Boolean status;

    public UserResponse(LocalDateTime createdAt, LocalDateTime updatedAt, String id, String firstName, String lastName, String username, String email, Boolean status) {
        super(createdAt, updatedAt);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.status = status;
    }
}