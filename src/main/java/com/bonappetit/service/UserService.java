package com.bonappetit.service;

import com.bonappetit.model.dto.UserLoginBindingModel;
import com.bonappetit.model.dto.UserRegisterBindingModel;
import org.springframework.stereotype.Service;


public interface UserService {

    boolean register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();
}
