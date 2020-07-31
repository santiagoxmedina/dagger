package com.sanmed.dagger.dagger;

import com.sanmed.dagger.LoginActivity;
import com.sanmed.dagger.ui.LoginViewModel;
import com.sanmed.dagger.ui.loginpassword.LoginPasswordFragment;
import com.sanmed.dagger.ui.username.LoginUsernameFragment;

import dagger.Subcomponent;


@ActivityScope
@Subcomponent
public interface LoginComponent {
    // Factory that is used to create instances of this subcomponent
    @Subcomponent.Factory
    interface Factory {
        LoginComponent create();
    }

    void inject(LoginViewModel loginViewModel);
    // All LoginActivity, LoginUsernameFragment and LoginPasswordFragment
    // request injection from LoginComponent. The graph needs to satisfy
    // all the dependencies of the fields those classes are injecting
    void inject(LoginActivity LoginActivity);
    void inject(LoginUsernameFragment loginUsernameFragment);
    void inject(LoginPasswordFragment loginPasswordFragment);
}