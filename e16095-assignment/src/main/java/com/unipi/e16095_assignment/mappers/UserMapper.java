package com.unipi.e16095_assignment.mappers;

import com.unipi.e16095_assignment.dtos.LoginResponseDto;
import com.unipi.e16095_assignment.entities.Users;

public class UserMapper {

    public static LoginResponseDto userEntityToResponseDtoMapper(Users user) {
        LoginResponseDto loginResponseDto = new LoginResponseDto();

        loginResponseDto.setId(user.getId());
        loginResponseDto.setUsername(user.getUsername());
        loginResponseDto.setEmail(user.getEmail());
        loginResponseDto.setRoleEnum(user.getRole());
        loginResponseDto.setAllowed(true);

        return loginResponseDto;
    }

}
