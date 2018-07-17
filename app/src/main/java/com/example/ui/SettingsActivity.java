package com.example.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.mybanner.R;

public class SettingsActivity extends AppCompatActivity {

    private ImageView mLeftBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        mLeftBack = (ImageView) findViewById(R.id.left_back);
        mLeftBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }

    //back事件回退动画
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Log.e("TAG", "back事件");
            finish();
            overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
        }
        return super.onKeyDown(keyCode, event);
    }
}
