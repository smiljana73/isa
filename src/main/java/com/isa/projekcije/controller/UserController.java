package com.isa.projekcije.controller;

import com.isa.projekcije.model.RegisteredUser;
import com.isa.projekcije.model.User;
import com.isa.projekcije.model.dto.LoginDTO;
import com.isa.projekcije.model.dto.RegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.isa.projekcije.service.UserService;

import java.util.Optional;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(
            value = "/login",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        User user = this.userService.findUser(loginDTO);

        if (user != null && user.getPassword().equals(loginDTO.getPassword())) {
            return new ResponseEntity(user, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }


    @RequestMapping(
            value = "/registerUser",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerUser(@RequestBody RegistrationDTO registrationDTO) {
        if(registrationDTO.isEmpty()){
            return new ResponseEntity(new RuntimeException("Missing mandatory fields!"),HttpStatus.BAD_REQUEST);
        }

        if(!(registrationDTO.correctPassword())){
            return new ResponseEntity(new RuntimeException("Passwords do not match!"),HttpStatus.BAD_REQUEST);
        }

        if(userService.emailExists(registrationDTO)){
            return new ResponseEntity(new RuntimeException("Email already exists!"),HttpStatus.BAD_REQUEST);
        }
        User registeredUser = userService.createUser(registrationDTO);
        return new ResponseEntity<>(registeredUser,HttpStatus.CREATED);

    }

}