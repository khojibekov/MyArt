package com.example.myart;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.myart.ui.art.Orders.OrdersFragment;
import com.example.myart.ui.art.Wish.WishFragment;
import com.google.android.material.navigation.NavigationView;


import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import javax.annotation.Nullable;

public class MainActivity extends AppCompatActivity {

    private static final int HOME_FRAGMENT = 0;
    private static final int CART_FRAGMENT = 1;
    private static final int ORDERS_FRAGMENT = 2;
    private static final int WISHLIST_FRAGMENT = 3;
    private static final int REWARDS_FRAGMENT = 4;
    private static final int ACCOUNT_FRAGMENT = 5;
    private ImageView actionbarLogo;
    private NavigationView navigationView;
    private FrameLayout mFrameLayout;
    private static int currentFragment = -1;
    private AppBarConfiguration mAppBarConfiguration;

    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        actionbarLogo = findViewById(R.id.action_bar_logo);

        setSupportActionBar(toolbar);
        window=getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);


        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_art, R.id.nav_orders, R.id.nav_reward, R.id.nav_card, R.id.nav_wish, R.id.nav_account, R.id.nav_out)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        NavigationUI.setupWithNavController(navigationView, navController);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.app_name, R.string.app_name);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);

        navigationView.getMenu().getItem(0).setChecked(true);

        mFrameLayout = findViewById(R.id.main_frame_layout);
        setFragment(new HomeFragment(), HOME_FRAGMENT);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (currentFragment == HOME_FRAGMENT) {
                currentFragment = -1;
                super.onBackPressed();
            } else {
                invalidateOptionsMenu();
                setFragment(new HomeFragment(), HOME_FRAGMENT);
                navigationView.getMenu().getItem(0).setChecked(true);
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if (currentFragment == HOME_FRAGMENT) {
            getMenuInflater().inflate(R.menu.main, menu);
            actionbarLogo.setVisibility(View.GONE);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.main_search_icon) {
            //Todo : search
            return true;
        } else if (id == R.id.main_notfication_icon) {
            //Todo : notification
            return true;
        } else if (id == R.id.main_cart_icon) {
            gotoFragment("Моя Карта", new MyCartFragment(), CART_FRAGMENT);
        }
        return super.onOptionsItemSelected(item);
    }

    private void gotoFragment(String title, Fragment fragment, int fragmentNo) {
        actionbarLogo.setVisibility(View.GONE);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(title);
        invalidateOptionsMenu();
        setFragment(fragment, fragmentNo);
        if (fragmentNo == CART_FRAGMENT) {
            navigationView.getMenu().getItem(3).setChecked(true);
        }
    }

    public boolean onNavigationItemSelected(MenuItem menuItem) {
        //Handle navigation view item clicks here.
        int id = menuItem.getItemId();
        if (id == R.id.nav_art) {
            invalidateOptionsMenu();
            gotoFragment("My Art", new HomeFragment(), HOME_FRAGMENT);
        } else if (id == R.id.nav_orders) {
            gotoFragment("Мои Заказы", new MyOrdersFragment(), ORDERS_FRAGMENT);


        } else if (id == R.id.nav_reward) {
            gotoFragment("Мои Бонусы", new MyRewardsFragment(), REWARDS_FRAGMENT);

        } else if (id == R.id.nav_card) {
            gotoFragment("Моя Карта", new MyCartFragment(), CART_FRAGMENT);


        } else if (id == R.id.nav_wish) {
            gotoFragment("Мои Желания", new MyWishlistFragment(), WISHLIST_FRAGMENT);
        } else if (id == R.id.nav_account) {
            gotoFragment("Мои Аккаунт", new MyAccountFragment(), ACCOUNT_FRAGMENT);
        } else if (id == R.id.nav_out) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void setFragment(Fragment fragment, int fragmentNo) {
        if (fragmentNo != currentFragment) {
            if (fragmentNo == REWARDS_FRAGMENT){



            }else {


            }


            currentFragment = fragmentNo;
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            fragmentTransaction.replace(mFrameLayout.getId(), fragment);
            fragmentTransaction.commit();
        }

    }
}