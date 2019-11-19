package com.checksplit.sommer.checksplit.selectItemsActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.checksplit.sommer.checksplit.BR;
import com.checksplit.sommer.checksplit.R;
import com.checksplit.sommer.checksplit.selectItemsActivity.viewModels.SelectItemRowViewModel;
import com.checksplit.sommer.checksplit.databinding.ItemSelectionFragmentBinding;
import com.checksplit.sommer.checksplit.databinding.SelectItemsRowBinding;
import com.checksplit.sommer.checksplit.selectItemsActivity.viewModels.ItemSelectionFragmentViewModel;

import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

public class ItemSelectionFragment extends Fragment {

    ItemSelectionFragmentBinding binding;
    ItemSelectionFragmentViewModel itemSelectionFragmentViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.item_selection_fragment,null,false);
        binding.setLifecycleOwner(this);

        itemSelectionFragmentViewModel = new ItemSelectionFragmentViewModel();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addItemsToList();
    }

    private void addItemsToList() {
        List<SelectItemRowViewModel> items = itemSelectionFragmentViewModel.createItems();
        for (SelectItemRowViewModel item : items) {
            SelectItemsRowBinding itemsRowBinding = DataBindingUtil.inflate(getLayoutInflater(),R.layout.select_items_row,null,false);
            itemsRowBinding.setVariable(BR.model, item);
            itemsRowBinding.setLifecycleOwner(this);
            binding.itemsList.addView(itemsRowBinding.getRoot());
        }
    }
}
