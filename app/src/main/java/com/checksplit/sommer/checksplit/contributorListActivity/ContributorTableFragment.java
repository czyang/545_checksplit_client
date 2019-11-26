package com.checksplit.sommer.checksplit.contributorListActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.checksplit.sommer.checksplit.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ContributorTableFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.contributor_table_fragment, container, false);
        return root;
    }
}
