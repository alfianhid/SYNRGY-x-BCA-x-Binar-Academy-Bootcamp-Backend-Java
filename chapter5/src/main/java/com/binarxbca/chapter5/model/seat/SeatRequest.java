package com.binarxbca.chapter5.model.seat;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;

public class SeatRequest {
    @NotEmpty
    @Schema(example = "usernamesaya")
    private String username;

    @NotEmpty
    @Schema(example = "email_saya@gmail.com")
    private String email;

    @NotEmpty
    @Schema(example = "$*#P4sSw0RdY4n95uSaH#*$")
    private String password;

    private Boolean status;
}
