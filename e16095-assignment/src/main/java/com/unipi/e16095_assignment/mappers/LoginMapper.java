package com.unipi.e16095_assignment.mappers;

import com.unipi.e16095_assignment.dtos.LoginRequestDto;
import com.unipi.e16095_assignment.dtos.LoginResponseDto;

public class LoginMapper {

    public LoginResponseDto requestToResponseMapper(LoginRequestDto loginRequestDto) {
        LoginResponseDto loginResponseDto = new LoginResponseDto();

        loginResponseDto.setUsername(loginRequestDto.getUsername());


//        loginResponseDto.setRoleEnum();
    }

}
