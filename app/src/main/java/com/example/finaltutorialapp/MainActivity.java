package com.example.finaltutorialapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.finaltutorialapp.fragment.javaFragment;
import com.example.finaltutorialapp.htmlFragment.myHtmlFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int HOME_FRAGMENT = 0;
    private static final int Html_FRAGMENT = 1;
    private long backPressedTime;
    private Toast backToast;

    public static Boolean showCart = false;


    private  int currentFragment = -1;

    private NavigationView navigationView;

    private AppBarConfiguration mAppBarConfiguration;
    private FrameLayout frameLayout;

    private ImageView actionBarLogo;

    private Window window;
    private Toolbar toolbar;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
      //  actionBarLogo = findViewById(R.id.actionbar_logo);
        setSupportActionBar(toolbar);


        window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);


        frameLayout = findViewById(R.id.main_framelayout);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        View headerView = navigationView.getHeaderView(0);
        if (showCart)
        {
            drawer.setDrawerLockMode(1);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            gotoFragment("My Cart",new MyCartFragment(),-2);

        }else {
            setFragment(new javaFragment(), HOME_FRAGMENT);
        }




    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (currentFragment == HOME_FRAGMENT) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getMenuInflater().inflate(R.menu.main, menu);
        }
        return true;

    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        int id = item.getItemId();
//        if (id == R.id.main_search_icon) {
//
//            return true;
//
//        } else if (id == R.id.main_notification) {
//
//            return true;
//        } else if (id == R.id.main_cartItem) {
//            gotoFragment("My Cart", new MyCartFragment(), CART_FRAGMENT);
//
//            return true;
//        }else if (id==android.R.id.home)
//        {
//            if (showCart){
//                showCart=false;
//                finish();
//            }
//        }
//
//
//        return super.onOptionsItemSelected(item);
//    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void gotoFragment(String title, Fragment fragment, int fragmentNo) {
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(title);
//        actionBarLogo.setVisibility(View.GONE);
        invalidateOptionsMenu();
        setFragment(fragment, fragmentNo);
        if (fragmentNo == HOME_FRAGMENT) {
            navigationView.getMenu().getItem(3).setChecked(true);

        }
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.javaTutorial) {

//            actionBarLogo.setVisibility(View.VISIBLE);
            invalidateOptionsMenu();
            setFragment(new javaFragment(), HOME_FRAGMENT);

        } else if (id == R.id.htmlTutorial) {

            gotoFragment("My Html", new myHtmlFragment(), Html_FRAGMENT);


        } else if (id == R.id.quiz) {
            Intent intent = new Intent(MainActivity.this, QuizActivity.class);
            startActivity(intent);

        } else if (id == R.id.htmlquiz)
        {
            Intent intent = new Intent(MainActivity.this,HtmlQuizActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setFragment(Fragment fragment, int fragmentNo) {
            currentFragment = fragmentNo;
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            fragmentTransaction.replace(frameLayout.getId(), fragment);
            fragmentTransaction.commit();


        }


    }

