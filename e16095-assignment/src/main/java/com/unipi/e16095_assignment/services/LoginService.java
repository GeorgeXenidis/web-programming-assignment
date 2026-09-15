package com.unipi.e16095_assignment.services;

import com.unipi.e16095_assignment.dtos.UserDto;
import com.unipi.e16095_assignment.repositories.UserRepository;
import com.unipi.e16095_assignment.dtos.LoginRequestDto;
import com.unipi.e16095_assignment.entities.Users;
import jakarta.servlet.http.HttpSession;
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
            return new UserDto(null, "", "", "", null);
        }

        Users user = optionalUser.get();
        if(!user.getPassword().equals(loginRequestDto.getPassword())) {
            return new UserDto(null, loginRequestDto.getUsername(), "", "", null);
        }

        return entityToDtoUserMapper(user);
    }

    public ModelAndView constructModelForResponse(UserDto userDto, HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();

        if (userDto.getId() == null) {// User's ID will be null if user gave invalid credentials
            httpSession.setAttribute("loggedInUser", null);

            modelAndView.setViewName("errorPage");
            modelAndView.addObject("message", "Unable to login, please try again!");

            return modelAndView;
        }

        httpSession.setAttribute("loggedInUser", userDto);
        httpSession.setAttribute("userRole", userDto.getRole());

//        Suppose that announcements will represent something like main page of sorts...
        modelAndView.setViewName("redirect:/api/level-user/announcements/all/");

        return modelAndView;
    }

}
