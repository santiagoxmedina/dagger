package com.sanmed.dagger.ui.username;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginUsernameViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LoginUsernameViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}