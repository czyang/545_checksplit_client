package com.checksplit.sommer.checksplit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.checksplit.sommer.checksplit.databinding.FragmentSampleBinding;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

public class FragmentSample extends Fragment {

    private FragmentSampleBinding fragmentSampleBinding;

    public FragmentSample() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        fragmentSampleBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_sample,null,false);

        return fragmentSampleBinding.getRoot();
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentSampleBinding.label.setText("Fragment From Code");
    }

    public FragmentSampleBinding getFragmentSampleBinding() {
        return fragmentSampleBinding;
    }
}
