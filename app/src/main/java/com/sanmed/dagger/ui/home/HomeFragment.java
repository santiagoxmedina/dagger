package com.sanmed.dagger.ui.home;

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

import com.google.android.material.snackbar.Snackbar;
import com.sanmed.dagger.R;
import com.sanmed.dagger.dagger.HomeInject;
import com.sanmed.dagger.dagger.MyApplication;

import javax.inject.Inject;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    @Inject
    HomeInject homeInject;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(homeInject!=null){
            Snackbar.make(requireView(),homeInject.test(),Snackbar.LENGTH_SHORT);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        ((MyApplication) requireActivity().getApplicationContext()).appComponent.inject(this);
        super.onAttach(context);
    }
}