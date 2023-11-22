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
import android.widget.TextView;

public class fragment_carrouselle extends Fragment {

    private TextView textView;
    private ImageView imageView, nextimage;

    String textview;
    int image;
    boolean val;
    public fragment_carrouselle(String textview, int image ){
        this.textview=textview;
        this.image=image;
    }

    public  fragment_carrouselle(String textview, int image, boolean val){
        this.val=val;
        this.textview=textview;
        this.image=image;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.activity_fragment_carrouselle, container, false);
        this.textView = view.findViewById(R.id.carrous_descrip);
        imageView = view.findViewById(R.id.image_carrous);
        nextimage = view.findViewById(R.id.next_carrous);
        textView.setText(textview.toString());
        imageView.setImageResource(image);
        if(val==true){
            nextimage.setVisibility(View.VISIBLE);
        }
        nextimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(requireActivity(), dashboard.class));
            }
        });
        return view;
    }
}