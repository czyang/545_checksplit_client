package com.checksplit.sommer.checksplit;


import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.checksplit.sommer.checksplit.databinding.ActivityMainBinding;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

public class MainActivity extends AppCompatActivity {
    FragmentSample fragmentSampleFromReplace;
    QRScanFragment qrScanFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set up binding for MainActivity
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setLifecycleOwner(this);

        // Create Text Model. Set it as a variable in MainActivity Binding
        // TextModel textModel = new TextModel();
        // activityMainBinding.setVariable(BR.model, textModel);

        // Create a fragment by code.
        // Inside 'activity_main.xml' there is an FrameLayout with id 'fragmentContainer' tag.
        // This fragment will replace that object
        fragmentSampleFromReplace = new FragmentSample();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragmentSampleFromReplace).commit();

        qrScanFragment = new QRScanFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerQRScan, qrScanFragment).commit();

        // Inside 'activity_main' there is an <include> tag with the id 'fragmentSampleIncluded'
        // This is an included layout that has no code behind it. We can access its elements with binding
        activityMainBinding.fragmentInclude.label.setText("Layout From Include");
    }
}
