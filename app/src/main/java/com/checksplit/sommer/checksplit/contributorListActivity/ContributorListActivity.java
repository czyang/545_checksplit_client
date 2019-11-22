package com.checksplit.sommer.checksplit.contributorListActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.checksplit.sommer.checksplit.R;
import com.checksplit.sommer.checksplit.databinding.ContributorListActivityBinding;
import com.checksplit.sommer.checksplit.selectItemsActivity.viewModels.ItemSelectionFragmentViewModel;
import com.checksplit.sommer.checksplit.viewModels.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class ContributorListActivity extends Fragment {

    ContributorListActivityBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.contributor_list_activity,null,false);

        ViewModelProvider.Factory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication());
        ViewModelProvider viewModelProvider = new ViewModelProvider(getActivity(),factory);
        ItemSelectionFragmentViewModel itemSelectionFragmentViewModel = viewModelProvider.get(ItemSelectionFragmentViewModel.class);

        organizeItems(itemSelectionFragmentViewModel.getItems());

        return binding.getRoot();
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
