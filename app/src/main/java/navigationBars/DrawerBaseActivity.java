package navigationBars;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.android.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

import authentication.SignIn;
import commonClasses.Profile;
import user.HomeScreenUser;

public class DrawerBaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;

    TextView emailTextView;

    FirebaseAuth mAuth;

    @Override
    public void setContentView(View view) {
        drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer_base, null);
        FrameLayout container = drawerLayout.findViewById(R.id.activityContainerID);
        container.addView(view);
        super.setContentView(drawerLayout);

        Toolbar toolbar = drawerLayout.findViewById(R.id.toolBarID);
        setSupportActionBar(toolbar);

        NavigationView navigationView = drawerLayout.findViewById(R.id.navViewID);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView1 = findViewById(R.id.navViewID);
        navigationView1.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.profileMenuID) {
            start_Profile_activity();
        }
        else if (id == R.id.homeMenuID) {
            start_HomeScreenUser_activity();
        }
        else if (id == R.id.logoutMenuID) {
            FirebaseAuth.getInstance().signOut();
            start_SignIn_activity();
        }


        return false;
    }

    public void allocateActivityTitle(String titleString) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(titleString);
        }
    }

    public void start_Profile_activity() {
        finish();
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    public void start_HomeScreenUser_activity() {
        finish();
        Intent intent = new Intent(this, HomeScreenUser.class);
        startActivity(intent);
    }

    public void start_SignIn_activity() {
        finish();
        Intent intent = new Intent(this, SignIn.class);
        startActivity(intent);
    }
}