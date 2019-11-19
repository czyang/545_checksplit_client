package com.checksplit.sommer.checksplit.Utils;

import android.content.Context;
import android.content.Intent;

public class NavigationUtils {

    static public void presentActivity(Context currentActivity, Class toActivity) {
        Intent myIntent = new Intent(currentActivity, toActivity);
//        myIntent.putExtra("key", value); //Optional parameters
        currentActivity.startActivity(myIntent);
    }
}
