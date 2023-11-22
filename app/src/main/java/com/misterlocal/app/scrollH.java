package com.misterlocal.app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class scrollH extends Fragment {

    private ImageView imageView;
    private TextView  textView;
    private LinearLayout linearLayout;
    String image, descript;
    public scrollH(String image, String descript){
        this.image=image;
        this.descript=descript;
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.activity_scroll_h, container, false);
        this.textView = view.findViewById(R.id.textscrollh);
        imageView = view.findViewById(R.id.imgscroolh);
        linearLayout=view.findViewById(R.id.scroolimg);
        textView.setText(descript.toString());
        String uri="https://misterlocal.000webhostapp.com/"+image;
        Picasso.get().load(uri).into(imageView);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(requireActivity(), composantscroolh.class));
            }
        });
        return view;
    }
}