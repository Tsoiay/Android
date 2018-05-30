package com.tsoiay.ui.Layout;

import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.tsoiay.ui.R;

public class Run_ErrandsActivity extends AppCompatActivity {

    private ImageView back = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.run_errands_activity);
        back = findViewById(R.id.img_back);
        InitTitleBar();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });
        /*
         * 代
         * 码
         * 区
         * */
    }

    private void InitTitleBar(){
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
    }

    public void back(){
        new Thread(){
            @Override
            public void run() {
                Instrumentation ins = new Instrumentation();
                ins.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
            }
        }.start();
    }
}
