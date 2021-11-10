package com.dataversity.happywedz;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.dataversity.happywedz.utils.Tools;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {
    Context context;
    BottomNavigationView bottomNav;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        context = this;

        Tools.setSystemBarColor(this, R.color.white);
        Tools.setSystemBarLight(this);

        bottomNav = findViewById(R.id.bottomnav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_vendore, R.id.navigation_shop, R.id.navigation_idea, R.id.navigation_planning)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNav, navController);

    }

   /* private void animateBottomIcon(int itemIndex, boolean isChecked) {
        final View view = menuView.getChildAt(itemIndex).findViewById(com.google.android.material.R.id.icon);
        ObjectAnimator translateUpAnimator = ObjectAnimator.ofFloat(view, "translationY",
                0,
                (float) (-(bottomNav.getHeight() / 2))).setDuration(500);
        if(!isChecked) {
            translateUpAnimator.start();
        }
        if(currentItemIndex != -1) {
            final View currentView = menuView.getChildAt(currentItemIndex).findViewById(com.google.android.material.R.id.icon);
            ObjectAnimator translateDownAnimator = ObjectAnimator.ofFloat(currentView, "translationY",
                    0,
                    (float) (-(bottomNav.getHeight() / 2))).setDuration(500);
            if (!isChecked) {
                translateDownAnimator.reverse();
            }
        }
    }*/

}