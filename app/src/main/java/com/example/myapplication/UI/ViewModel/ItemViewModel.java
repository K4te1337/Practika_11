package com.example.myapplication.UI.ViewModel;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.myapplication.DATA.DataSources.Repositoriy;
import com.example.myapplication.DATA.Model.DataList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
public class ItemViewModel extends ViewModel {
    private Repositoriy repository = new Repositoriy();
    private final MutableLiveData<Repositoriy> liveData = new MutableLiveData<>(new Repositoriy());
    public LiveData<List<DataList>> getItems() {
        return repository.getItems1();
    }
    public void createList(Context context, Map<String, Integer> cathegories) {
        Objects.requireNonNull(liveData.getValue()).createDatabase(context, cathegories);
    }
    public LiveData<Repositoriy> getLiveData() {
        return liveData;
    }
}