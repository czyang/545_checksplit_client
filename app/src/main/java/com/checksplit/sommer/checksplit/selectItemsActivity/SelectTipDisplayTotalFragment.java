package com.checksplit.sommer.checksplit.selectItemsActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.checksplit.sommer.checksplit.R;
import com.checksplit.sommer.checksplit.databinding.SelectTipDisplayTotalFragmentBinding;
import com.checksplit.sommer.checksplit.selectItemsActivity.viewModels.ItemSelectionFragmentViewModel;
import com.checksplit.sommer.checksplit.selectItemsActivity.viewModels.SelectItemRowViewModel;

import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

public class SelectTipDisplayTotalFragment extends Fragment {

    SelectTipDisplayTotalFragmentBinding binding;

    ViewModelProvider viewModelProvider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.select_tip_display_total_fragment,null,false);
        binding.setLifecycleOwner(this);

        ViewModelProvider.Factory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication());
        viewModelProvider = new ViewModelProvider(getActivity(),factory);
        ItemSelectionFragmentViewModel itemSelectionFragmentViewModel = viewModelProvider.get(ItemSelectionFragmentViewModel.class);

        return binding.getRoot();
    }
}
