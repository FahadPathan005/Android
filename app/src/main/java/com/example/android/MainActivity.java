/*
this class is used for intro.
after the intro it will automatically goto sign in page.
 */

package com.example.android;

import authentication.SignIn;
import commonClasses.Profile;
import commonClasses.StartActivities;
import commonClasses.UpdateProfile;
import navigationBars.DrawerBaseActivity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.databinding.ActivityMainBinding;

public class MainActivity extends DrawerBaseActivity {

    Button startButton;
    ActivityMainBinding activityMainBinding;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        start_activity();
    }

    @Override
    public void onBackPressed() {
        finish();
        System.exit(0);
    }

    public static void exitProgram() {
        System.exit(0);
    }

    public void start_activity() {
        Intent intent = new Intent(this, SignIn.class);
        startActivity(intent);
        Toast.makeText(this, "MainActivity", Toast.LENGTH_SHORT).show();
        //finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
//        StartActivities startActivities = new StartActivities();
//        startActivities.start_SignIn_activity(getApplicationContext());
    }

}