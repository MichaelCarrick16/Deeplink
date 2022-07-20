package com.example.a1deeplink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        Log.e("HiepPD","onNewIntent");
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Lấy ra đường dẫn uri mà khi click từ ngoài app
        Intent intent = getIntent();
        Uri uri = intent.getData();
        // Handle logic
        String id;
        if(uri != null){
            String getID[] = uri.toString().trim().split("=");
            id = getID[1].trim();
            if(id.equals("1")){
                startActivity(new Intent(this,SecondAct.class));
                finish();
            }else{
                Toast.makeText(this, "ID = "+id+" không phải ID = 1", Toast.LENGTH_SHORT).show();
            }
        }
    }
}