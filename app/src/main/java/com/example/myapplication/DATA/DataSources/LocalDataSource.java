package com.example.myapplication.DATA.DataSources;
import com.example.myapplication.R;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.myapplication.DATA.Model.DataList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class LocalDataSource implements DataSource {
    private Map<Integer, DataList> items = new HashMap<>();
    public LocalDataSource() {
        for (int i = 0; i < 203; i++) {
            String text = "Котик №" + (i + 1);
            items.put(R.drawable.cat, new DataList(text,R.drawable.cat));
        }
    }
    @Override
    public LiveData<List<DataList>> getItems() {
        MutableLiveData<List<DataList>> liveData = new MutableLiveData<>();
        liveData.setValue(new ArrayList<>(items.values()));
        return liveData;
    }
    @Override
    public LiveData<DataList> getItem(int itemId) {
        MutableLiveData<DataList> liveData = new MutableLiveData<>();
        liveData.setValue(items.get(itemId));
        return liveData;
    }
}