package com.checksplit.sommer.checksplit;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TextModel extends ViewModel {

    private  MutableLiveData<String> text = new MutableLiveData<>();

    private String buttonLabel = "Click Here";

    public TextModel() {
        text.setValue("Hello");
    }

    public void onClickView() {
        if (text.getValue().equals("Hello")) {
            text.setValue("World");
        } else  {
            text.setValue("Hello");
        }
    }

    public MutableLiveData<String> getText() {
        return text;
    }

    public String getButtonLabel() {
        return buttonLabel;
    }
}
