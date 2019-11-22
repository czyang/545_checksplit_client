package com.checksplit.sommer.checksplit.selectItemsActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.checksplit.sommer.checksplit.BR;
import com.checksplit.sommer.checksplit.R;
import com.checksplit.sommer.checksplit.Utils.UserNames;
import com.checksplit.sommer.checksplit.selectItemsActivity.viewModels.SelectItemRowViewModel;
import com.checksplit.sommer.checksplit.databinding.ItemSelectionFragmentBinding;
import com.checksplit.sommer.checksplit.databinding.SelectItemsRowBinding;
import com.checksplit.sommer.checksplit.selectItemsActivity.viewModels.ItemSelectionFragmentViewModel;
import com.checksplit.sommer.checksplit.viewModels.Item;

import java.util.ArrayList;
import java.util.List;

import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class ItemSelectionFragment extends Fragment {

    ItemSelectionFragmentBinding binding;
    ItemSelectionFragmentViewModel itemSelectionFragmentViewModel;

    private List<SelectItemRowViewModel> selectItemRowViewModelList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.item_selection_fragment,null,false);
        binding.setLifecycleOwner(this);

        ViewModelProvider.Factory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication());
        ViewModelProvider viewModelProvider = new ViewModelProvider(getActivity(),factory);

        itemSelectionFragmentViewModel = viewModelProvider.get(ItemSelectionFragmentViewModel.class);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addItemsToList();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        updateItem();
                    }
                });
            }
        },3000);
    }

    private void addItemsToList() {
        List<Item> items = itemSelectionFragmentViewModel.createItems();
        for (Item item : items) {
            // configure row item
            SelectItemRowViewModel selectItemRowViewModel = new SelectItemRowViewModel(item, this);
            selectItemRowViewModel.noSelectionTypeface = ResourcesCompat.getFont(getContext(),R.font.arial);
            selectItemRowViewModel.userSelectedColor = getResources().getColor(R.color.selection_blue,null);
            selectItemRowViewModel.userSelectedFont = ResourcesCompat.getFont(getContext(),R.font.arialbd);
            selectItemRowViewModel.otherUserSelectedColor = getResources().getColor(R.color.selection_other_user,null);
            selectItemRowViewModel.otherUserSelectedFont = ResourcesCompat.getFont(getContext(),R.font.ariali);

            // set up binding and attach row item as variable
            SelectItemsRowBinding itemsRowBinding = DataBindingUtil.inflate(getLayoutInflater(),R.layout.select_items_row,null,false);
            itemsRowBinding.setVariable(BR.model, selectItemRowViewModel);
            itemsRowBinding.setLifecycleOwner(this);
            binding.itemsList.addView(itemsRowBinding.getRoot());

            // add to row item list
            selectItemRowViewModelList.add(selectItemRowViewModel);
        }
    }

    private void updateItem() {
        selectItemRowViewModelList.get(1).getItem().updateUserSelected(UserNames.user1);
        selectItemRowViewModelList.get(2).getItem().updateUserSelected(UserNames.user2);
    }

}
