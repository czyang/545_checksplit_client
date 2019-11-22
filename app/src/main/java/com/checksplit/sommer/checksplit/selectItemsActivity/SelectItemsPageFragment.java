package com.checksplit.sommer.checksplit.selectItemsActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.checksplit.sommer.checksplit.R;
import com.checksplit.sommer.checksplit.Utils.NavigationUtils;
import com.checksplit.sommer.checksplit.contributorListActivity.ContributorListActivity;
import com.checksplit.sommer.checksplit.databinding.SelectItemsPageFragmentBinding;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

public class SelectItemsPageFragment extends Fragment {


    SelectItemsPageFragmentBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.select_items_page_fragment,null,false);

        ItemSelectionFragment itemSelectionFragment = new ItemSelectionFragment();
        getChildFragmentManager().beginTransaction().replace(R.id.select_items_container,itemSelectionFragment).commit();

        SelectTipDisplayTotalFragment selectAndTipFragment = new SelectTipDisplayTotalFragment();
        getChildFragmentManager().beginTransaction().replace(R.id.tax_and_total_container,selectAndTipFragment).commit();

        binding.continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationUtils.pushFragment(getFragmentManager(), R.id.fragmentContainer, new ContributorListActivity());
            }
        });

        return binding.getRoot();
    }
}
