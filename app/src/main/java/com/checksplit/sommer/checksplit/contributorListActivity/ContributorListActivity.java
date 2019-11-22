package com.checksplit.sommer.checksplit.contributorListActivity;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.checksplit.sommer.checksplit.R;
import com.checksplit.sommer.checksplit.databinding.ContributorListActivityBinding;
import com.checksplit.sommer.checksplit.selectItemsActivity.viewModels.ItemSelectionFragmentViewModel;
import com.checksplit.sommer.checksplit.viewModels.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

public class ContributorListActivity extends AppCompatActivity {

    ContributorListActivityBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.contributor_list_activity);

        // get item view model and parse items
        ViewModelProvider.Factory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication());
        ViewModelProvider viewModelProvider = new ViewModelProvider(this,factory);
        ItemSelectionFragmentViewModel itemSelectionFragmentViewModel = viewModelProvider.get(ItemSelectionFragmentViewModel.class);
        organizeItems(itemSelectionFragmentViewModel.getItems());
    }

    public void organizeItems(List<Item> items) {
        Map<String,Item> organizedItems = new HashMap<>();
        for (Item item : items) {
            if (item.selectedUserId.getValue().length() > 0) {
                organizedItems.put(item.selectedUserId.getValue(), item);
            }
        }
    }


}
