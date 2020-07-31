package com.sanmed.dagger.ui.loginpassword;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.sanmed.dagger.LoginActivity;
import com.sanmed.dagger.R;
import com.sanmed.dagger.ui.LoginViewModel;

import javax.inject.Inject;

public class LoginPasswordFragment extends Fragment {

    private LoginPasswordViewModel dashboardViewModel;
    // Fields that need to be injected by the login graph
    @Inject
    LoginViewModel loginViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(LoginPasswordViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        ((LoginActivity) getActivity()).loginComponent.inject(this);

        // Now you can access loginViewModel here and onCreateView too
        // (shared instance with the Activity and the other Fragment)
    }
}