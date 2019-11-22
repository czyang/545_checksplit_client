package com.checksplit.sommer.checksplit.Utils;

import android.content.Context;
import android.content.Intent;

import com.checksplit.sommer.checksplit.R;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class NavigationUtils {

    static public void presentActivity(Context currentActivity, Class toActivity) {
        Intent myIntent = new Intent(currentActivity, toActivity);
        currentActivity.startActivity(myIntent);
    }

    static public void pushFragment(FragmentManager fragmentManager, int containerId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        fragmentTransaction.addToBackStack(null).add(containerId,fragment).commit();
    }
}
