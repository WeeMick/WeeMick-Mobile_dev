package com.mb.myfragmentapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private MutableLiveData<MyModel> myLiveModel;

    public MyViewModel()
    {
        myLiveModel = new MutableLiveData<MyModel>();

        myLiveModel.setValue(new MyModel());
    }

    LiveData<MyModel> getModel()
    {
        return myLiveModel;
    }
}
