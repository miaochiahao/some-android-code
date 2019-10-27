package com.fakestudio.crashMe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class TestClassCastException extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_null_pointer_exception);

        Intent intent = getIntent();

        // 此处不崩溃应用，而是toast异常，方便查看exception
        try {
            String s = (String) intent.getSerializableExtra("serializable_key");
        } catch (Exception e){
            Toast.makeText(TestClassCastException.this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
