package com.mycompany.myapp.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO representing a password change required data - current and new password.
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PasswordChangeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String currentPassword;
    private String newPassword;
}
