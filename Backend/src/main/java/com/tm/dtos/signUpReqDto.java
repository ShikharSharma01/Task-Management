package com.tm.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpReqDto {

    private String username;
    private String password;
    private String email;

}
