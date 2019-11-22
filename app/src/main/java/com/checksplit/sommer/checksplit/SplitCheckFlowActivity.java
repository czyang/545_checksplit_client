package com.checksplit.sommer.checksplit;

import android.os.Bundle;

import com.checksplit.sommer.checksplit.databinding.SplitCheckFlowBinding;
import com.checksplit.sommer.checksplit.selectItemsActivity.SelectItemsPageFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class SplitCheckFlowActivity extends AppCompatActivity  {

    SplitCheckFlowBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.split_check_flow);

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new SelectItemsPageFragment()).commit();

    }
}
