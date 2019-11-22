package com.checksplit.sommer.checksplit.viewModels;

import com.checksplit.sommer.checksplit.Utils.UserNames;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Item extends ViewModel {

    public String itemName;
    public Float price;
    public MutableLiveData<String> selectedUserId = new MutableLiveData<>();

    public Item(String itemName, Float price) {
        this.itemName = itemName;
        this.price = price;
        selectedUserId.setValue("");
    }

    public void updateUserSelected(String userId) {
        if (!selectedByOtherUser()) {
            if (userId.equals(selectedUserId.getValue())) {
                // same user selected, deselect
                deselect();
            } else {
                // update selected user ID
                selectedUserId.setValue(userId);
            }
        }
    }

    private void deselect() {
        selectedUserId.setValue("");
    }

    public boolean selectedByUser() {
        if (selectedUserId.getValue().equals(UserNames.userMain)) {
            return true;
        }
        return false;
    }

    public boolean selectedByOtherUser () {
        if (!selectedUserId.getValue().equals(UserNames.userMain) && selectedUserId.getValue().length() > 0) {
            return true;
        }
        return false;
    }

}
