package com.checksplit.sommer.checksplit.Utils;

import android.content.Context;
import android.content.Intent;

import com.checksplit.sommer.checksplit.select_items_activity.SelectItemsActivity;

import androidx.appcompat.app.AppCompatActivity;

public class NavigationUtils {

    static public void presentActivity(Context currentActivity, Class toActivity) {
        Intent myIntent = new Intent(currentActivity, toActivity);
//        myIntent.putExtra("key", value); //Optional parameters
        currentActivity.startActivity(myIntent);
    }
}
