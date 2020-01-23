package com.rafi.training.activitymain;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int TEXT_REQUEST = 1;
    public static final String EXTRA_MESSAGE = "com.example.android.MainActivity.extra.extra.MESAGGE";
    private static final String EXTRA_MESAGGE ="com.example.android.MainActivity.extra.MESAGGE";
    private TextView mReplyHeadTextview;
    private TextView mReplyTextview;
    private EditText etMesagge;
    private static final String Log_Tag = MainActivity.class.getSimpleName();
    private String mesagge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMesagge=findViewById(R.id.editText_main);
        mReplyHeadTextview=findViewById(R.id.text_header_reply);
        mReplyTextview=findViewById(R.id.text_header);
        mesagge = etMesagge.getText().toString();
    }

    public void lauchSecondActivity(View view) {
        Log.d(Log_Tag, "Button clicked!");
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(EXTRA_MESAGGE,mesagge);
        startActivity(intent);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST){
            if (resultCode ==  RESULT_OK){
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyHeadTextview.setVisibility(View.VISIBLE);
                mReplyTextview.setText(reply);
                mReplyTextview.setVisibility(View.VISIBLE);
            }
        }
    }
}
