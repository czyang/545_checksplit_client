package com.checksplit.sommer.checksplit;


import android.os.Bundle;
import com.checksplit.sommer.checksplit.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class MainActivity extends AppCompatActivity {
    QRScanFragment qrScanFragment;
    HomeButtonsFragment homeButtonsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set up binding for MainActivity
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setLifecycleOwner(this);

        getSupportActionBar().hide();

        homeButtonsFragment = new HomeButtonsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, homeButtonsFragment).commit();

        qrScanFragment = new QRScanFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerQRScan, qrScanFragment).commit();
    }
}
