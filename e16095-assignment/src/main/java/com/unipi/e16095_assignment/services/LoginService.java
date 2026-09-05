package com.unipi.e16095_assignment.services;

import com.unipi.e16095_assignment.UserRepository;
import com.unipi.e16095_assignment.dtos.LoginRequestDto;
import com.unipi.e16095_assignment.dtos.LoginResponseDto;
import com.unipi.e16095_assignment.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.unipi.e16095_assignment.mappers.UserMapper.userEntityToResponseDtoMapper;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public LoginResponseDto performLoginAction(LoginRequestDto loginRequestDto) {
        LoginResponseDto loginResponseDto;

        Optional<Users> optionalUser = userRepository.findByUsername(loginRequestDto.getUsername());
        if (optionalUser.isEmpty()) {
            return loginResponseDto = new LoginResponseDto(null, null, null, null, false);
        }

        Users user = optionalUser.get();
        if(!user.getPassword().equals(loginRequestDto.getPassword())) {
            return loginResponseDto = new LoginResponseDto(null, loginRequestDto.getUsername(), null, null, false);
        }

        return userEntityToResponseDtoMapper(user);
    }

}
