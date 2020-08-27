package com.dcTr.validation;


import com.dcTr.web.dto.UserRegistrationDto;
import org.springframework.stereotype.Component;

@Component
public class UserValidation {


    public void validateUserEmail(UserRegistrationDto registrationDto){
        String email = registrationDto.getEmail();
        String patternEmail = "\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b";
        if(!email.matches(patternEmail)){
            throw new RuntimeException("Invalid email");
        }
    }
}
