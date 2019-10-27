package com.fakestudio.crashMe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ComponentName cn = new ComponentName(MainActivity.this, "com.fakestudio.crashMe.TestNullPointerException");
                Intent intent = new Intent();
                intent.setComponent(cn);
                startActivity(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ComponentName cn = new ComponentName(MainActivity.this, "com.fakestudio.crashMe.TestClassCastException");
                Intent intent = new Intent();
                intent.setComponent(cn);
                intent.putExtra("serializable_key", BigInteger.valueOf(1));
                startActivity(intent);
            }
        });

        Button button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ComponentName cn = new ComponentName(MainActivity.this, "com.fakestudio.crashMe.TestIndexOutOfBoundsException");
                Intent intent = new Intent();
                intent.setComponent(cn);
                ArrayList<Integer> user_id = new ArrayList<Integer>();
                intent.putExtra("user_id", user_id);
                startActivity(intent);
            }
        });

        Button button4 = (Button) findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ComponentName cn = new ComponentName("com.fakestudio.victim", "com.fakestudio.victim.MainActivity");
                Intent intent = new Intent();
                intent.setComponent(cn);
                intent.putExtra("serializable_key", new SelfSerializableData()); // 此处传入的是自定义的Serializable对象，由于客户端无法找到该类型 会崩溃
                startActivity(intent);
            }
        });
    }

    static class SelfSerializableData implements Serializable{
        private static final long serialVersionUID = 42L;
        public SelfSerializableData(){
            super();
        }
    }
}
