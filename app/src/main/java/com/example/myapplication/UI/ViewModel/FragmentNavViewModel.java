package com.example.myapplication.UI.ViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.myapplication.DATA.Model.FragmentNavigationData;

public class FragmentNavViewModel extends ViewModel {

    private MutableLiveData<FragmentNavigationData> data = new MutableLiveData<>();
    public FragmentNavViewModel() {
        data.setValue(new FragmentNavigationData());
    }
    public MutableLiveData<FragmentNavigationData> getData() {
        return data;
    }
}