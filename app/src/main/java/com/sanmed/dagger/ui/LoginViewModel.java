package com.sanmed.dagger.ui;

import com.sanmed.dagger.dagger.ActivityScope;
import com.sanmed.dagger.dagger.UserRepository;

import javax.inject.Inject;
@ActivityScope
public class LoginViewModel {
    private final UserRepository userRepository;

    @Inject
    public LoginViewModel(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public String test() {
        return "OK";
    }
}
