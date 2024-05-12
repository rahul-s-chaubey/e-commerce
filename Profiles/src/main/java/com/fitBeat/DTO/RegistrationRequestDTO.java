package com.fitBeat.DTO;

import lombok.Data;

@Data
public class RegistrationRequestDTO extends BaseDTO
{
        private String emailId;
        private String password;
        private String firstName;
        private String lastName;
        private String phoneNo;
        private char userType;
}
