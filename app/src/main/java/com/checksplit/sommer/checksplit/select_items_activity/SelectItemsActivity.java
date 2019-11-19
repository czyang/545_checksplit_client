package com.checksplit.sommer.checksplit.select_items_activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.checksplit.sommer.checksplit.R;
import com.checksplit.sommer.checksplit.databinding.SelectItemsActivityBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class SelectItemsActivity extends AppCompatActivity {


    SelectItemsActivityBinding binding;

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        binding = DataBindingUtil.setContentView(this, R.layout.select_items_activity);
        return binding.getRoot();
    }



}
