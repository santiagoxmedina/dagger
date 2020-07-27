package com.sanmed.dagger.dagger;

import com.sanmed.dagger.ui.home.HomeFragment;

import dagger.Component;

@Component
public interface ApplicationComponent {
    void inject(HomeFragment homeFragment);
}
