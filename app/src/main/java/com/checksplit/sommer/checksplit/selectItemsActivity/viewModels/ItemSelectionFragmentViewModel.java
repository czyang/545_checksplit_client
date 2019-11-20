package com.checksplit.sommer.checksplit.selectItemsActivity.viewModels;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.ViewModel;

public class ItemSelectionFragmentViewModel extends ViewModel {

    private List<SelectItemRowViewModel> items;

    public List<SelectItemRowViewModel> createItems() {

        List<SelectItemRowViewModel> items = new ArrayList<>();

        items.add(new SelectItemRowViewModel("Hamburger", 12.00f));
        items.add(new SelectItemRowViewModel("IPA Beer", 7.00f));
        items.add(new SelectItemRowViewModel("Chicken Dinner", 18.00f));
        items.add(new SelectItemRowViewModel("Red Wine", 8.00f));
        items.add(new SelectItemRowViewModel("Chicken Parmesan", 19.99f));
        items.add(new SelectItemRowViewModel("White Wine", 8.00f));
        items.add(new SelectItemRowViewModel("Clam Chowder Bowl", 4.00f));
        items.add(new SelectItemRowViewModel("Lobster Ravioli", 13.50f));
        items.add(new SelectItemRowViewModel("Mac and Cheese", 12.00f));
        items.add(new SelectItemRowViewModel("Tuna Salad", 9.50f));
        items.add(new SelectItemRowViewModel("Pilsner Beer", 6.00f));
        items.add(new SelectItemRowViewModel("Soda", 3.25f));
        this.items = items;
        return items;
    }

    public List<SelectItemRowViewModel> getItems() {
        return items;
    }
}
