package com.example.myapplication.DATA.DataSources;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.room.Room;
import com.example.myapplication.DATA.DataSources.Files.AppSpecificDataSources;
import com.example.myapplication.DATA.DataSources.Files.CommonFileDataSources;
import com.example.myapplication.DATA.DataSources.Room.AppDatabase;
import com.example.myapplication.DATA.DataSources.Room.DAO.ListDAO;
import com.example.myapplication.DATA.DataSources.Room.Entities.Category;
import com.example.myapplication.DATA.DataSources.SharedPreferences.SharedPreferencesDS;
import com.example.myapplication.DATA.Model.DataList;
import java.util.List;
import java.util.Map;
public class Repositoriy {
    private AppSpecificDataSources appSpecDataSource;
    private CommonFileDataSources commonFileDataSource;
    private SharedPreferencesDS Localds;
    private AppDatabase db;
    public Repositoriy() {}
    public Repositoriy(Context context, String appSpecDSFileName, String commonFDSFileName) {
        this.appSpecDataSource = new AppSpecificDataSources(context, appSpecDSFileName);
        this.commonFileDataSource = new CommonFileDataSources(context, commonFDSFileName);
    }
    public void writeAppSpecDS(String inputContent) {
        appSpecDataSource.writeAppSpecificDS("\n" + inputContent);
    }
    public String readAppSpecDS() {
        return appSpecDataSource.readAppSpecificDS();
    }
    public boolean writeCommonFileDS(String inputContent) {
        return commonFileDataSource.writeContent("\n" + inputContent);
    }
    public String readCommonFileDS() {
        return commonFileDataSource.readFile();
    }
    private DataSource dataSource = new LocalDataSource();
    public LiveData<List<DataList>> getItems1() {
        return dataSource.getItems();
    }
    public LiveData<DataList> getItem(int itemId) {
        return dataSource.getItem(itemId);
    }
    public void createLocalds(Context context) {
        if (Localds == null) {
            Localds = new SharedPreferencesDS(context);}
    }
    public String getLocalName() {
        if (Localds == null) return null;
        else return Localds.getString("Name");
    }
    public Integer getLocalImg() {
        if (Localds == null) return null;
        else return Localds.getInt("Img");
    }
    public void setLocalName(String name) {
        if (Localds == null) return;
        else Localds.writeString("Name", name);
    }
    public void setLocalImg(int img) {
        if (Localds == null) return;
        else Localds.writeInt("Img", img);}
    public DataList getItems() {
        if (Localds == null) return null;
        else return new DataList(
                Localds.getString("Name"),
                Localds.getInt("Img")
        );
    }
    public void createDatabase(Context context, Map<String, Integer> values) {
        if (db != null) return;
        db = Room.databaseBuilder(context,
                AppDatabase.class, "List").allowMainThreadQueries().build();
        ListDAO listDAO = db.listDAO();

        for (Map.Entry<String, Integer> entry : values.entrySet()) {
            insertCategory(entry.getKey(), entry.getValue());
        }
    }
    public  Category getCategory(String itemName){
        return db.listDAO().getCategoryByName(itemName);
    }
    public  void insertCategory(String catName, int img){
        Category cathegory= new Category();
        cathegory.catName = catName;
        cathegory.img = img;
        db.listDAO().insertCategory(cathegory);

    }
}