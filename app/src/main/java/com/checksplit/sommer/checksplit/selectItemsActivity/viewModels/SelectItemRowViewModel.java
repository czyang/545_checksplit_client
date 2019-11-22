package com.checksplit.sommer.checksplit.selectItemsActivity.viewModels;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;

import com.checksplit.sommer.checksplit.Utils.UserNames;
import com.checksplit.sommer.checksplit.viewModels.Item;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class SelectItemRowViewModel extends ViewModel {

    private Item item;
    private MutableLiveData<SpannableString> itemNameSpannable = new MutableLiveData<>();
    private MutableLiveData<SpannableString> priceSpannable = new MutableLiveData<>();
    private MutableLiveData<Integer> labelColor = new MutableLiveData<>();
    private MutableLiveData<Typeface> labelFont = new MutableLiveData<>();

    public Typeface noSelectionTypeface;

    public int userSelectedColor;
    public Typeface userSelectedFont;
    public int otherUserSelectedColor;
    public Typeface otherUserSelectedFont;


    public SelectItemRowViewModel(final Item item, LifecycleOwner lifecycleOwner) {
        this.item = item;
        itemNameSpannable.setValue(new SpannableString(""));
        priceSpannable.setValue(new SpannableString(""));
        labelColor.setValue(Color.BLACK);
        labelFont.setValue(noSelectionTypeface);

        itemNameSpannable.setValue(new SpannableString("test"));
        priceSpannable.setValue(new SpannableString("test"));

        // whenever the item's select user is updated, we want to update the UI
        item.selectedUserId.observe(lifecycleOwner, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                updateStyles();
            }
        });
    }

    public void itemClick() {
        item.updateUserSelected(UserNames.userMain);
    }

    public MutableLiveData<SpannableString> getItemNameSpannable() {
        return itemNameSpannable;
    }

    public MutableLiveData<SpannableString> getPriceSpannable() {
        return priceSpannable;
    }

    public void updateStyles() {
        SpannableString nameContent = new SpannableString(item.itemName);

        String formattedPrice = String.format("$%.2f", item.price);
        SpannableString priceContent = new SpannableString(formattedPrice);

        if (item.selectedByUser() == true) {
            labelColor.setValue(userSelectedColor);
            labelFont.setValue(userSelectedFont);
            nameContent.setSpan(new UnderlineSpan(), 0, item.itemName.length(), 0);
            priceContent.setSpan(new UnderlineSpan(), 0, formattedPrice.length(), 0);
        } else if (item.selectedByOtherUser() == true) {
            labelColor.setValue(otherUserSelectedColor);
            labelFont.setValue(otherUserSelectedFont);
        } else {
            labelColor.setValue(Color.BLACK);
            labelFont.setValue(noSelectionTypeface);
            nameContent.setSpan(new UnderlineSpan(), 0, item.itemName.length(), 0);
            priceContent.setSpan(new UnderlineSpan(), 0, formattedPrice.length(), 0);
        }

        itemNameSpannable.setValue(nameContent);
        priceSpannable.setValue(priceContent);
    }

    public MutableLiveData<Integer> getLabelColor() {
        return labelColor;
    }

    public MutableLiveData<Typeface> getLabelFont() {
        return labelFont;
    }

    public Item getItem() {
        return item;
    }
}
