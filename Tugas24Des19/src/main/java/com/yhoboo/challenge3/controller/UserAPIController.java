package com.yhoboo.challenge3.controller;

import com.yhoboo.challenge3.entity.UserEntity;
import com.yhoboo.challenge3.service.PasswordConverterService;
import com.yhoboo.challenge3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.xml.ws.Response;

@RestController
@RequestMapping(value = {"/user"})
public class UserAPIController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordConverterService passwordConverterService;

    @PostMapping(value = "/addUser",headers = "Accept=application/json")
    public ResponseEntity<Void> addUser (UserEntity userEntity, UriComponentsBuilder uriComponentsBuilder){
        userEntity.setPassword(passwordConverterService.convertPassword(userEntity.getPassword()));
        userService.insertUser(userEntity);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/user/{id}").buildAndExpand(userEntity.getUserId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "findById",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserEntity> findByUserId(@RequestParam(value = "userId",defaultValue = "")int id){

        UserEntity userEntity = userService.findById(id);

        if(userEntity.equals(null)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(userEntity);
        }else {
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(userEntity);
        }
    }
}
