package com.tm.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class signUpReqDto {

    private String name;
    private String password;
    private String confirm_password;
    private String email;

}
