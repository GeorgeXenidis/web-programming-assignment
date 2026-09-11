package com.unipi.e16095_assignment.services;

import com.unipi.e16095_assignment.dtos.UserDto;
import com.unipi.e16095_assignment.enums.RoleEnum;
import com.unipi.e16095_assignment.repositories.UserRepository;
import com.unipi.e16095_assignment.dtos.LoginRequestDto;
import com.unipi.e16095_assignment.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import static com.unipi.e16095_assignment.mappers.UserMapper.entityToDtoUserMapper;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public UserDto performLoginAction(LoginRequestDto loginRequestDto) {
        Optional<Users> optionalUser = userRepository.findByUsername(loginRequestDto.getUsername());
        if (optionalUser.isEmpty()) {
            return new UserDto(null, null, "", null, null, false);
        }

        Users user = optionalUser.get();
        if(!user.getPassword().equals(loginRequestDto.getPassword())) {
            return new UserDto(null, loginRequestDto.getUsername(), "", null, null, false);
        }

        return entityToDtoUserMapper(user);
    }

    public ModelAndView constructModelForResponse(UserDto userDto) {
        ModelAndView modelAndView = new ModelAndView();

        RoleEnum userRole = userDto.getRole();
        if(userRole == null) {
            modelAndView.setViewName("errorPage");
            modelAndView.addObject("errorMessage", "User role not found...");

            return modelAndView;
        }
        switch (userRole) {
            case ADMIN -> {
                modelAndView.setViewName("adminMainPage");
            }
            case TECHNICIAN -> {
                modelAndView.setViewName("technicianMainPage");
            }
            case USER -> {
                modelAndView.setViewName("simpleUserMainPage");
            }
            default -> {
                modelAndView.setViewName("errorPage");
                modelAndView.addObject("errorMessage", "Could not resolve a page to return...");
            }
        }

        return modelAndView;
    }

}
