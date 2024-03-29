package com.example.login;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;


import com.example.login.Ca.DetailCa;

import com.example.login.Pro.Detail;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Login extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {

    private String[] imageUrls = new String[]{
            "https://i.imgur.com/BIFJWwM.png",
            "https://i.imgur.com/6lXsS1n.jpg"

    };
    private static final int MY_REQUEST_CODE = 1234;
    List<AuthUI.IdpConfig> providers;
    Button signout, changelang;
    private DrawerLayout drawer;
    ImageButton phone_button, carema_button;

    ViewPager viewPager;

    @NonNull
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        viewPager = findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this, imageUrls);
        viewPager.setAdapter(adapter);

        carema_button = findViewById(R.id.carema_button);

        carema_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent carema = new Intent(Login.this, DetailCa.class);
                startActivity(carema);
                Toast.makeText(getApplicationContext(), "Carema", Toast.LENGTH_LONG);
                ;
            }
        });
        phone_button = findViewById(R.id.phone_button);
        phone_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phone = new Intent(Login.this, Detail.class);
                startActivity(phone);
                Toast.makeText(getApplicationContext(), "Phone", Toast.LENGTH_LONG);
                ;
            }
        });


        changelang = findViewById(R.id.changelang);
        changelang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangelanuage();
            }
        });
        signout = findViewById(R.id.signout);
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Logout
                AuthUI.getInstance()
                        .signOut(Login.this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                signout.setEnabled(false);
                                showSignInOptions();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login.this, "" + e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                });

            }
        });


        providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.FacebookBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build()

        );
        showSignInOptions();
    }


    private void showSignInOptions() {
        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder()
                        .setAvailableProviders(providers)

                        .build(), MY_REQUEST_CODE

        );
//        Intent   intent = new Intent(this, Insert.class);
//        startActivity(intent);
//        Toast.makeText(getApplicationContext(),"Login",Toast.LENGTH_LONG);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MY_REQUEST_CODE) {
            IdpResponse response = IdpResponse.fromResultIntent(data);
            if (resultCode == RESULT_OK) {
                //Get User
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                //Show email on Toast
                Toast.makeText(this, "" + user.getEmail(), Toast.LENGTH_SHORT).show();
                //Set Button Signout
                signout.setEnabled(true);
            } else {
                Toast.makeText(this, "" + response.getError().getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.nav_phone:
                Intent intent = new Intent(this, Detail.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Phone", Toast.LENGTH_LONG);
                break;


            case R.id.nav_carema:
                Intent intent2 = new Intent(this, DetailCa.class);
                startActivity(intent2);
                Toast.makeText(getApplicationContext(), "Carema", Toast.LENGTH_LONG);
                break;


            case R.id.signout:
                Intent intent1 = new Intent(this, Login.class);
                startActivity(intent1);
                Toast.makeText(getApplicationContext(), "Signout", Toast.LENGTH_LONG);

                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbarmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();

        if (id == R.id.contact) {
            Intent intent = new Intent(this, Insert.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "You click contact", Toast.LENGTH_LONG).show();
        } else if (id == R.id.about) {
            Intent intentx = new Intent(this, About.class);
            startActivity(intentx);
            Toast.makeText(getApplicationContext(), "You click about", Toast.LENGTH_LONG).show();

        }

        return true;
    }



    private void showChangelanuage() {
        final String[] listitems ={"Chinese","English"};
        final AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
        builder.setTitle("Choose Language");
        builder.setSingleChoiceItems(listitems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if(i == 0) {
                    setLocale("zh");
                    recreate();
                }
                    else if(i == 1) {
                    setLocale("en");
                    recreate();
                    }
                    dialog.dismiss();
                }
            });
            AlertDialog mdialog = builder.create();
        mdialog.show();


    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale=locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("MY_LANG",lang);
        editor.apply();

    }
public  void  loadLocale(){
        SharedPreferences preferences= getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String lanuage = preferences.getString("MY_LANG","");
        setLocale(lanuage);
    }
}