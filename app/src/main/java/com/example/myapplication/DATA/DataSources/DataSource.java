package com.example.myapplication.DATA.DataSources;
import androidx.lifecycle.LiveData;
import com.example.myapplication.DATA.Model.DataList;
import com.example.myapplication.DATA.Model.Item;
import java.util.List;
public interface DataSource {
    LiveData<List<DataList>> getItems();
    LiveData<DataList> getItem(int itemId);
}