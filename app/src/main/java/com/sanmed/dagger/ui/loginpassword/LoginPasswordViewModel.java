package com.sanmed.dagger.ui.loginpassword;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginPasswordViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LoginPasswordViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}