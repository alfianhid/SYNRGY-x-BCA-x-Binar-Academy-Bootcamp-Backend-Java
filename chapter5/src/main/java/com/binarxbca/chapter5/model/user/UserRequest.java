package com.binarxbca.chapter5.model.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotEmpty(message = "first_name can not be empty")
    @Schema(example = "Nama")
    private String firstName;

    @NotEmpty(message = "last_name can not be empty")
    @Schema(example = "Nama Saya")
    private String lastName;

    @NotEmpty(message = "username can not be empty")
    @Schema(example = "usernamesaya")
    private String username;

    @NotEmpty(message = "email can not be empty")
    @Schema(example = "email_saya@gmail.com")
    private String email;

    @NotEmpty(message = "password can not be empty")
    @Schema(example = "$*#P4sSw0RdY4n95uSaH#*$")
    private String password;
}