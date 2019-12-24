package com.yhoboo.challenge3.controller;

import com.yhoboo.challenge3.dao.ResponseDao;
import com.yhoboo.challenge3.entity.RoleEntity;
import com.yhoboo.challenge3.entity.UserEntity;
import com.yhoboo.challenge3.service.RoleService;
import com.yhoboo.challenge3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = {"/role"})
public class RoleAPIController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "addRole", headers = "Accept=application/json")
    public ResponseEntity<Void> createRole (RoleEntity roleEntity, UriComponentsBuilder uriComponentsBuilder){
        roleService.insertRole(roleEntity);
        HttpHeaders headers= new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/role/{id}").buildAndExpand(roleEntity.getRoleId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "findById",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleEntity> findByRoleId (@RequestParam(value = "roleId",defaultValue = "")int id){
        RoleEntity roleEntity = roleService.findByRoleId(id);

        if(roleEntity.equals(null)){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(roleEntity);
        }else{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(roleEntity);
        }
    }

    @GetMapping(value = "listByRole",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDao> listByRoleId (@RequestParam(value = "listId", defaultValue = "")int id){

        ResponseDao responseDao = new ResponseDao();
        List<UserEntity> userEntities = userService.listByRoleId(id);

        responseDao.setData(userEntities);
        if(userEntities.isEmpty()){
            responseDao.setMessage("Error!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(responseDao);
        }else{
            responseDao.setMessage("List-By-Role-ID: ");
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(responseDao);
        }
    }

}
