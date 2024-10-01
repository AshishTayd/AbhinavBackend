package com.gtasterix.AbhinavNGO.mapper;

import com.gtasterix.AbhinavNGO.DTO.userDTO;
import com.gtasterix.AbhinavNGO.model.User;
import com.gtasterix.AbhinavNGO.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapper {
  public static User User;

    public static userDTO toDTO(User user){
        userDTO userDTO=new userDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setMobileno(user.getMobileno());
        userDTO.setAmount(user.getAmount());
        return userDTO;
    }

public static User toEntity(userDTO userDTO) {

    User user = new User();
    user.setId(userDTO.getId());
    user.setName(userDTO.getName());
    user.setMobileno(userDTO.getMobileno());
    user.setEmail(userDTO.getEmail());
    user.setAmount(userDTO.getAmount());
    return user;


}}