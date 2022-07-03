package com.example.moodtracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.moodtracker.views.Connections;
import com.example.moodtracker.views.Groups;
import com.example.moodtracker.views.MoreFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.moodtracker.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    Groups groups = new Groups();
    MoreFragment moreFragment = new MoreFragment();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_analysis, R.id.navigation_calendar, R.id.navigation_more)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    public void groups(View view) {
        Intent intent = new Intent(MainActivity.this, Groups.class);
        startActivity(intent);
    }

    public void connections(View view) {
        Intent i = new Intent(MainActivity.this, Connections.class);
        startActivity(i);
    }
}