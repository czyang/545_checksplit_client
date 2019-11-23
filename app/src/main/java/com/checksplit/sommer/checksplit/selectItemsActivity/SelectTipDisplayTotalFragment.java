package com.checksplit.sommer.checksplit.selectItemsActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.checksplit.sommer.checksplit.R;
import com.checksplit.sommer.checksplit.Utils.UserNames;
import com.checksplit.sommer.checksplit.databinding.SelectTipDisplayTotalFragmentBinding;
import com.checksplit.sommer.checksplit.selectItemsActivity.viewModels.ItemSelectionFragmentViewModel;
import com.checksplit.sommer.checksplit.selectItemsActivity.viewModels.SelectItemRowViewModel;
import com.checksplit.sommer.checksplit.viewModels.Item;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class SelectTipDisplayTotalFragment extends Fragment {

    private SelectTipDisplayTotalFragmentBinding binding;

    private ViewModelProvider viewModelProvider;

    private ItemSelectionFragmentViewModel itemSelectionFragmentViewModel;

    private float selectedTax;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.select_tip_display_total_fragment,null,false);
        binding.setLifecycleOwner(this);

        ViewModelProvider.Factory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication());
        viewModelProvider = new ViewModelProvider(getActivity(),factory);
        itemSelectionFragmentViewModel = viewModelProvider.get(ItemSelectionFragmentViewModel.class);

        for (Item item : itemSelectionFragmentViewModel.getItems()) {
            item.selectedUserId.observe(this, new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    updateTotal();
                }
            });
        }

        setupTipButotns();

        return binding.getRoot();
    }

    private void setupTipButotns() {
        for (int i = 0; i < binding.tipLayout.getChildCount(); i++) {
            final Button button = (Button)binding.tipLayout.getChildAt(i);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    resetButtonBackgrounds();
                    float value = Float.parseFloat(button.getText().toString().replace("%","")) / 100;
                    if (value == selectedTax) {
                        selectedTax = 0.00f;
                    } else {
                        selectedTax = value;
                        button.setBackground(getResources().getDrawable(R.drawable.tip_selection_button_selected));
                    }
                    updateTotal();
                }
            });
        }
    }

    private void resetButtonBackgrounds() {
        for (int i = 0; i < binding.tipLayout.getChildCount(); i++) {
            final Button button = (Button)binding.tipLayout.getChildAt(i);
            button.setBackground(getResources().getDrawable(R.drawable.tip_selection_button_unselected));
        }
    }

    private void updateTotal() {
        float total = 0.0f;
        for (Item item : itemSelectionFragmentViewModel.getItems()) {
            if (item.selectedByUser()) {
                total += item.price;
            }
        }

        float tip = total * selectedTax;

        float tax = total * .07f;

        float finalTotal = total + tax + tip;

        binding.total.setText(String.format("$%.2f", total));
        binding.tipEdit.setText(String.format("%.2f",tip));
        binding.finalTotal.setText(String.format("Total: %.2f", finalTotal));

    }
}
