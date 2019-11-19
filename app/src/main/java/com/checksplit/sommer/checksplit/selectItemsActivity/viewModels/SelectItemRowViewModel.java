package com.checksplit.sommer.checksplit.selectItemsActivity.viewModels;

import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SelectItemRowViewModel extends ViewModel {

    private String itemName;
    private Float price;
    private MutableLiveData<SpannableString> itemNameSpannable;
    private MutableLiveData<SpannableString> priceSpannable;
    private MutableLiveData<Boolean> selectedByUser;
    private MutableLiveData<Boolean> selectedByOtherUser;


    public SelectItemRowViewModel(String itemName, Float price) {
        this.itemName = itemName;
        this.price = price;
        selectedByUser = new MutableLiveData<>();
        selectedByUser.setValue(false);
        selectedByOtherUser = new MutableLiveData<>();
        selectedByOtherUser.setValue(false);
        itemNameSpannable = new MutableLiveData<>();
        itemNameSpannable.setValue(new SpannableString(""));
        priceSpannable = new MutableLiveData<>();
        priceSpannable.setValue(new SpannableString(""));
        updateItemNameSpannable();
        updateSpannablePrice();
    }

    public void itemClick() {
        if (!selectedByOtherUser.getValue()) {
            selectedByUser.setValue(!selectedByUser.getValue());
        }
    }

    public MutableLiveData<SpannableString> getItemNameSpannable() {
        return itemNameSpannable;
    }

    public void updateItemNameSpannable() {
        SpannableString content = new SpannableString(itemName);
        if (!selectedByOtherUser.getValue()) {
            content.setSpan(new UnderlineSpan(), 0, itemName.length(), 0);
        }
        itemNameSpannable.setValue(content);
    }

    public MutableLiveData<SpannableString> getPriceSpannable() {
        return priceSpannable;
    }

    public void updateSpannablePrice() {
        String formattedPrice = String.format("$%.2f", price);
        SpannableString content = new SpannableString(formattedPrice);
        if (!selectedByOtherUser.getValue()) {
            content.setSpan(new UnderlineSpan(), 0, formattedPrice.length(), 0);
        }
        priceSpannable.setValue(content);
    }

    public void updateSelectedByUser(Boolean status) {
        selectedByUser.setValue(status);
        updateItemNameSpannable();
        updateSpannablePrice();
    }

    public MutableLiveData<Boolean> getSelectedByUser() {
        return selectedByUser;
    }

    public void updateSelectedByOtherUser(Boolean status) {
        selectedByOtherUser.setValue(status);
        updateItemNameSpannable();
        updateSpannablePrice();
    }

    public MutableLiveData<Boolean> getSelectedByOtherUser() {
        return selectedByOtherUser;
    }
}
