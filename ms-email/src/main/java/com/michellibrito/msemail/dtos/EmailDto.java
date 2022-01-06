package com.michellibrito.msemail.dtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class EmailDto {

    @NotBlank
    private final String ownerRef;

    @NotBlank
    @Email
    private final String emailFrom;

    @NotBlank
    @Email
    private final String emailTo;

    @NotBlank
    private final String subject;

    @NotBlank
    private final String text;
}
