package com.checksplit.sommer.checksplit.selectItemsActivity.viewModels;

import android.text.Html;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SelectItemRowViewModel extends ViewModel {

    private String itemName;
    private Float price;
    private MutableLiveData<Boolean> selectedByUser;
    private MutableLiveData<Boolean> selectedByOtherUser;


    public SelectItemRowViewModel(String itemName, Float price) {
        this.itemName = itemName;
        this.price = price;
        selectedByUser = new MutableLiveData<>();
        selectedByUser.setValue(false);
        selectedByOtherUser = new MutableLiveData<>();
        selectedByOtherUser.setValue(false);
    }

    public void itemClick() {
        if (!selectedByOtherUser.getValue()) {
            selectedByUser.setValue(!selectedByUser.getValue());
        }
    }

    public SpannableString getFormattedName() {
        SpannableString content = new SpannableString(itemName);
        if (!selectedByOtherUser.getValue()) {
            content.setSpan(new UnderlineSpan(), 0, itemName.length(), 0);
        }
        return content;
    }

    public SpannableString getFormattedPrice() {
        String formattedPrice = String.format("$%.2f", price);
        SpannableString content = new SpannableString(formattedPrice);
        if (!selectedByOtherUser.getValue()) {
            content.setSpan(new UnderlineSpan(), 0, formattedPrice.length(), 0);
        }
        return content;
    }

    public void updateSelectedByUser(Boolean status) {
        selectedByUser.setValue(status);
    }

    public MutableLiveData<Boolean> getSelectedByUser() {
        return selectedByUser;
    }

    public void updateSelectedByOtherUser(Boolean status) {
        selectedByOtherUser.setValue(status);
    }

    public MutableLiveData<Boolean> getSelectedByOtherUser() {
        return selectedByOtherUser;
    }
}
