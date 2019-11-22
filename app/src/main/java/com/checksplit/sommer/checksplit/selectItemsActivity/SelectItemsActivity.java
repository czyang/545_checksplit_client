package com.checksplit.sommer.checksplit.selectItemsActivity;

import android.os.Bundle;
import android.view.View;

import com.checksplit.sommer.checksplit.R;
import com.checksplit.sommer.checksplit.Utils.NavigationUtils;
import com.checksplit.sommer.checksplit.contributorListActivity.ContributorListActivity;
import com.checksplit.sommer.checksplit.databinding.SelectItemsActivityBinding;
import com.checksplit.sommer.checksplit.selectItemsActivity.viewModels.SelectItemRowViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class SelectItemsActivity extends AppCompatActivity  {

    SelectItemsActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.select_items_activity);

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new SelectItemsPageFragment()).commit();

    }
}
