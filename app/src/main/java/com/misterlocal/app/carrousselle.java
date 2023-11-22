package com.misterlocal.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

public class carrousselle extends AppCompatActivity {

    int[] imagecarrousse={
            R.mipmap.search,
            R.mipmap.booking,
            R.mipmap.management
    };
    ViewPager viewPager;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrousselle);

        //Resources resources = getResources();
        String[] stringArray = getResources().getStringArray(R.array.my_string_array);

        Fragment[] fragments = new Fragment[stringArray.length];

        for (int i=0; i < stringArray.length; i++){
            if( i == stringArray.length-1){
                fragments[i] = new fragment_carrouselle(stringArray[i],imagecarrousse[i],true);
                break;
            }
                fragments[i] = new fragment_carrouselle(stringArray[i],imagecarrousse[i]);
        }

        viewPager = findViewById(R.id.carrouselle);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
    }
}