package com.example.myapplication.UI.View;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.UI.ViewModel.ItemDataViewModel;
import com.example.myapplication.R;
public class SecondFragment extends Fragment {
    private ItemDataViewModel viewModel;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TransitionInflater inflater = TransitionInflater.from(requireContext());
        setExitTransition(inflater.inflateTransition(R.transition.fade));
        setEnterTransition(inflater.inflateTransition(R.transition.slide_right));
        viewModel = new ViewModelProvider(this).get(ItemDataViewModel.class);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment, container, false);
        Button toThird = view.findViewById(R.id.to_third);
        toThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_SecondFragment_to_ThirdFragment);
            }
        });
        String res = getArguments().getString("res");
        TextView text = view.findViewById(R.id.text_view);
        text.setText(res);
        Intent intent = getActivity().getIntent();
        if (intent != null && Intent.ACTION_SEND.equals(intent.getAction()) && intent.getType() != null) {
            if ("text/plain".equals(intent.getType())) {
                String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
                if (sharedText != null) {
                    text.setText(sharedText);
                }
            }
        }
        return view;
    }
}