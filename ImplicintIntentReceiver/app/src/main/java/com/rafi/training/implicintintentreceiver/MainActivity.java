package com.rafi.training.implicintintentreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvResultLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResultLink=findViewById(R.id.tv_result_link);

        Intent receivedIntent=getIntent();
        Uri uri=receivedIntent.getData();

        if (uri!= null){
            tvResultLink.setText(uri.toString());
        }
    }
}
