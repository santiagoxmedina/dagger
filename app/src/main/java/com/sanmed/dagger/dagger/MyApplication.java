package com.sanmed.dagger.dagger;

import android.app.Application;

public class MyApplication extends Application {
    public ApplicationComponent appComponent = DaggerApplicationComponent.create();
}
