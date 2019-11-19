package com.checksplit.sommer.checksplit.selectItemsActivity;

import android.os.Bundle;

import com.checksplit.sommer.checksplit.R;
import com.checksplit.sommer.checksplit.databinding.SelectItemsActivityBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class SelectItemsActivity extends AppCompatActivity {


    SelectItemsActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.select_items_activity);

        ItemSelectionFragment itemSelectionFragment = new ItemSelectionFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.select_items_container,itemSelectionFragment).commit();
    }

}
