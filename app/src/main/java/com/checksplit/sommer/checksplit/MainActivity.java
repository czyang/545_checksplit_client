package com.checksplit.sommer.checksplit;


import android.os.Bundle;
import com.checksplit.sommer.checksplit.databinding.ActivityMainBindingImpl;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBindingImpl activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        activityMainBinding.setLifecycleOwner(this);

        TextModel textModel = new TextModel();

        activityMainBinding.setVariable(BR.model, textModel);
    }
}
