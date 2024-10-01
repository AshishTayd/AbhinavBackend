package com.gtasterix.AbhinavNGO.Controller;

import com.gtasterix.AbhinavNGO.DTO.userDTO;
import com.gtasterix.AbhinavNGO.Service.UserService;
import com.gtasterix.AbhinavNGO.model.User;
import com.gtasterix.AbhinavNGO.util.React;
import org.apache.catalina.connector.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<React> addUser(@RequestBody userDTO userDTO) {
        try {
            userDTO savedUser = userService.addUser(userDTO); // Ensure savedBook is properly returned by UserService
//             React react = new React(); // Correct boolean 'false'
            React react=new React("User Added Successfully",savedUser,false);
             return ResponseEntity.status(HttpStatus.CREATED).body(react);
        }
        catch (Exception e) {
            React errorReact = new React("Failed to add User", e.getMessage(), true);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorReact);
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<React> getbyAll(){
        try {
            List<userDTO> getuser=userService.getAlluser();
            React react=new React("User getall Successfully",getuser,false);
            return ResponseEntity.status(HttpStatus.CREATED).body(react);

        }
        catch(Exception e){
            React errorreact = new React("Error retrieving user", e.getMessage(), true);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorreact);

        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<React> getbyid(@RequestParam Integer id){
        try{
            userDTO us=userService.getbyid(id);
            React react=new React("user get by id",us,false);
        return ResponseEntity.status(HttpStatus.CREATED).body(react);
        }
        catch(Exception e){
            React errorreact=new React("error retriving userid",e.getMessage(),true);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorreact);
        }
    }

}
