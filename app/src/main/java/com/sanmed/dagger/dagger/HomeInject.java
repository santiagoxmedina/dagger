package com.sanmed.dagger.dagger;

import javax.inject.Inject;

public class HomeInject {

    private final UserRepository userRepository;

    @Inject
    public HomeInject(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public String test() {
        return "OK";
    }
}
