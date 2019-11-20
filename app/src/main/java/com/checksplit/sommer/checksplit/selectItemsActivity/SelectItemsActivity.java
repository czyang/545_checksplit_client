package com.checksplit.sommer.checksplit.selectItemsActivity;

import android.os.Bundle;

import com.checksplit.sommer.checksplit.R;
import com.checksplit.sommer.checksplit.databinding.SelectItemsActivityBinding;
import com.checksplit.sommer.checksplit.selectItemsActivity.viewModels.SelectItemRowViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

public class SelectItemsActivity extends AppCompatActivity {


    SelectItemsActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.select_items_activity);

        ItemSelectionFragment itemSelectionFragment = new ItemSelectionFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.select_items_container,itemSelectionFragment).commit();

        SelectTipDisplayTotalFragment selectAndTipFragment = new SelectTipDisplayTotalFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.tax_and_total_container,selectAndTipFragment).commit();



    }

}
