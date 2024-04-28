package com.example.myapplication.UI.View;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import com.example.myapplication.DATA.Model.DataList;
import com.example.myapplication.R;
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder>{
    private final LayoutInflater inflater;
    private static Context parent;
    private final ArrayList<DataList> items;
    public MyRecyclerAdapter(Context context, ArrayList<DataList> items) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
        this.parent = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataList dataList = items.get(position);
        holder.text.setText(dataList.getName());
        holder.image.setImageResource(dataList.getImage());
        holder.itemView.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString("itemName", dataList.getName());
            Navigation.findNavController(view).navigate(R.id.action_FourFragment_to_FiveFragment, bundle);
        });
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;
        public ImageView image;
        public ViewGroup layout;
        public ViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.list_item_text_view);
            image = itemView.findViewById(R.id.list_item_image_view);
            layout = itemView.findViewById(R.id.item_root_container);
        }
    }
}