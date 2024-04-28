package com.example.myapplication.UI.ViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.myapplication.DATA.DataSources.Repositoriy;
import com.example.myapplication.DATA.Model.DataList;
public class ItemDataViewModel extends ViewModel {
    private Repositoriy repository = new Repositoriy();
    public LiveData<DataList> getItem(int itemId) {
        return repository.getItem(itemId);
    }
}