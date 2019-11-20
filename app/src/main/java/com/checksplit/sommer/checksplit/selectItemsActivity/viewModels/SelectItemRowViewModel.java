package com.checksplit.sommer.checksplit.selectItemsActivity.viewModels;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SelectItemRowViewModel extends ViewModel {

    private String itemName;
    private Float price;
    private MutableLiveData<SpannableString> itemNameSpannable = new MutableLiveData<>();
    private MutableLiveData<SpannableString> priceSpannable = new MutableLiveData<>();
    private MutableLiveData<Boolean> selectedByUser = new MutableLiveData<>();
    private MutableLiveData<Boolean> selectedByOtherUser = new MutableLiveData<>();
    private MutableLiveData<Integer> labelColor = new MutableLiveData<>();
    private MutableLiveData<Typeface> labelFont = new MutableLiveData<>();

    public Typeface noSelectionTypeface;

    public int userSelectedColor;
    public Typeface userSelectedFont;
    public int otherUserSelectedColor;
    public Typeface otherUserSelectedFont;


    public SelectItemRowViewModel(String itemName, Float price) {
        this.itemName = itemName;
        this.price = price;
        selectedByUser.setValue(false);
        selectedByOtherUser.setValue(false);
        itemNameSpannable.setValue(new SpannableString(""));
        priceSpannable.setValue(new SpannableString(""));
        labelColor.setValue(Color.BLACK);
        labelFont.setValue(noSelectionTypeface);
        updateItemNameSpannable();
        updateSpannablePrice();
    }

    public void itemClick() {
        updateSelectedByUser();
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

    public void updateSelectedByUser() {
        if (!selectedByOtherUser.getValue()) {
            Boolean status = !selectedByUser.getValue(); // flip the status
            selectedByUser.setValue(status);
            updateItemNameSpannable();
            updateSpannablePrice();

            if (status == true) {
                labelColor.setValue(userSelectedColor);
                labelFont.setValue(userSelectedFont);
            } else {
                labelColor.setValue(Color.BLACK);
                labelFont.setValue(noSelectionTypeface);
            }
        }
    }

    public MutableLiveData<Integer> getLabelColor() {
        return labelColor;
    }

    public MutableLiveData<Boolean> getSelectedByUser() {
        return selectedByUser;
    }

    public void updateSelectedByOtherUser(Boolean status) {
        selectedByOtherUser.setValue(status);
        updateItemNameSpannable();
        updateSpannablePrice();

        if (status == true) {
            labelColor.setValue(otherUserSelectedColor);
            labelFont.setValue(otherUserSelectedFont);
        } else {
            labelColor.setValue(Color.BLACK);
            labelFont.setValue(noSelectionTypeface);
        }
    }

    public MutableLiveData<Boolean> getSelectedByOtherUser() {
        return selectedByOtherUser;
    }

    public MutableLiveData<Typeface> getLabelFont() {
        return labelFont;
    }
}
