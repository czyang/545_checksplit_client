package com.checksplit.sommer.checksplit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.checksplit.sommer.checksplit.Utils.NavigationUtils;

import androidx.fragment.app.Fragment;

public class HomeButtonsFragment extends Fragment {


    public HomeButtonsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home_buttons, container, false);

        final Button button = (Button) root.findViewById(R.id.settings);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NavigationUtils.presentActivity(getActivity(), SplitCheckFlowActivity.class);
            }
        });

        return root;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
