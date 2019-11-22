package com.checksplit.sommer.checksplit.selectItemsActivity.viewModels;

import android.content.Context;

import com.checksplit.sommer.checksplit.viewModels.Item;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.ViewModel;

public class ItemSelectionFragmentViewModel extends ViewModel {

    private List<Item> items;

    public List<Item> createItems() {

        List<Item> items = new ArrayList<>();
        items.add(new Item("Hamburger", 12.00f));
        items.add(new Item("IPA Beer", 7.00f));
        items.add(new Item("Red Wine", 8.00f));
        items.add(new Item("Chicken Parmesan", 19.99f));
        items.add(new Item("White Wine", 8.00f));
        items.add(new Item("Clam Chowder Bowl", 4.00f));
        items.add(new Item("Lobster Ravioli", 13.50f));
        items.add(new Item("Mac and Cheese", 12.00f));
        items.add(new Item("Tuna Salad", 9.50f));
        items.add(new Item("Pilsner Beer", 6.00f));
        items.add(new Item("Soda", 3.25f));

        this.items = items;
        return items;
    }

    public List<Item> getItems() {
        return items;
    }
}
