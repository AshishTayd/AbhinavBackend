package com.gtasterix.AbhinavNGO.Service;

import com.gtasterix.AbhinavNGO.DTO.userDTO;
import com.gtasterix.AbhinavNGO.mapper.UserMapper;
import com.gtasterix.AbhinavNGO.model.User;
import com.gtasterix.AbhinavNGO.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String MOBILE_REGEX = "^[6-9][0-9]{9}$";
    private boolean validateMobileNumber(String mobileno) {
        if (mobileno == null || !Pattern.matches(MOBILE_REGEX, mobileno)) {
            throw new IllegalArgumentException("Invalid mobile number format");

        }
        return true;
    }
private boolean validateEmail(String email){
        if(email == null || !Pattern.matches(EMAIL_REGEX, email)){
            throw new IllegalArgumentException(("invalid email format"));
        }
        return true;
}

    public userDTO addUser(userDTO userDTO) throws Exception {
        if(validateMobileNumber(userDTO.getMobileno()) && validateEmail(userDTO.getEmail()) ){
//            User user=UserMapper.toEntity(userDTO);
//            userRepository.save(user);
//            return UserMapper.toDTO(user);

            User user= modelMapper.map(userDTO,User.class);
            userRepository.save(user);
            return modelMapper.map(user,userDTO.class);
        } else {
            throw new Exception("User not created");
        }
    }
    public List<userDTO> getAlluser()
    {
        return userRepository.findAll().stream().
                map(UserMapper::toDTO).
                collect(Collectors.toUnmodifiableList());

    }

    public userDTO getbyid(Integer id) throws RuntimeException {
        User use = userRepository.findById(id).orElse(null);
        if (use != null) {
            return UserMapper.toDTO(use);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }}
