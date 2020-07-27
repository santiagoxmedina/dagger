package com.sanmed.dagger.dagger;

import javax.inject.Inject;

public class UserRemoteDataSource {

    private final LoginRetrofitService loginRetrofitService;

    @Inject
    public UserRemoteDataSource(LoginRetrofitService loginRetrofitService) {
        this.loginRetrofitService = loginRetrofitService;
    }
}
