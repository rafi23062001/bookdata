package com.rafi.training.newaplikasi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OpenFragment extends AppCompatActivity {

    Button btn_fragmentone, btnTosimplefragment;
    SimpleFragment simpleFragment;
    SimpleFragmentSmall simpleFragmentSmall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_fragment);

        btnTosimplefragment=findViewById(R.id.btn_fragment_aplikasi);

        btn_fragmentone=findViewById(R.id.btn_fragment);

        simpleFragment=new SimpleFragment();
        simpleFragmentSmall=new SimpleFragmentSmall();

        //Fragment Maneger
        FragmentManager rafimanager = getSupportFragmentManager();

        //buat objeck fragment manager
        FragmentTransaction ft = rafimanager.beginTransaction();
        //tambahkan objeck simpleFragment (object) ke Frame
        ft.add(R.id.frame_fragmentsone,simpleFragment);
        //kemudian commit
        ft.commit();

        btn_fragmentone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame_fragmentsone,simpleFragmentSmall);
                ft.addToBackStack("Simple Fragment !");
                ft.commit();

                btnTosimplefragment.setVisibility(View.VISIBLE);
                btn_fragmentone.setVisibility(View.GONE);
            }
        });
        btnTosimplefragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame_fragmentsone,simpleFragment);
                ft.commit();

                btnTosimplefragment.setVisibility(View.GONE);
                btn_fragmentone.setVisibility(View.VISIBLE);
            }
        });
    }
}