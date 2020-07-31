package com.sanmed.dagger;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sanmed.dagger.dagger.LoginComponent;
import com.sanmed.dagger.dagger.MyApplication;
import com.sanmed.dagger.ui.LoginViewModel;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {

    public LoginComponent loginComponent;

    @Inject
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        // Creation of the login graph using the application graph
        loginComponent = ((MyApplication) getApplicationContext())
                .appComponent.loginComponent().create();

        // Make Dagger instantiate @Inject fields in LoginActivity
        loginComponent.inject(loginViewModel);



    }

}