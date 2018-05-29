package com.tsoiay.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tsoiay.ui.R;


public class PublishDialog extends Dialog {

    private RelativeLayout rlMain;

    private Context context;

    private LinearLayout Btn_new_things, Btn_run_errands, Btn_nearby, llBtnMenu;

    private Handler handler;

    private ImageView ivMenu;

    public PublishDialog(Context context) {
        this(context, R.style.main_publishdialog_style);
    }

    private PublishDialog(Context context, int theme) {
        super(context, theme);
        this.context = context;
        init();
    }


    /**
     * 初始化
     */
    private void init() {
        handler = new Handler();
        //填充视图
        setContentView(R.layout.main_dialog_publish);
        rlMain = (RelativeLayout) findViewById(R.id.mainPublish_dialog_rlMain);
        Btn_new_things = (LinearLayout) findViewById(R.id.new_things);
        Btn_run_errands = (LinearLayout) findViewById(R.id.run_errands);
        Btn_nearby = (LinearLayout) findViewById(R.id.nearby);
        llBtnMenu = (LinearLayout) findViewById(R.id.mainPublish_dialog_llBtnMenu);
        ivMenu = (ImageView) findViewById(R.id.mainPublish_dialog_ivMenu);

        llBtnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputDialog();
            }
        });
        rlMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputDialog();
            }
        });
    }


    /**
     * 进入对话框（带动画）
     */
    public void inputDialog() {
        Btn_new_things.setVisibility(View.INVISIBLE);
        Btn_run_errands.setVisibility(View.INVISIBLE);
        Btn_nearby.setVisibility(View.INVISIBLE);
        //背景动画
        rlMain.startAnimation(AnimationUtils.loadAnimation(context, R.anim.mainactivity_fade_in));
        //菜单按钮动画
        ivMenu.startAnimation(AnimationUtils.loadAnimation(context, R.anim.mainactivity_rotate_right));
        //选项动画
        Btn_new_things.setVisibility(View.VISIBLE);
        Btn_new_things.startAnimation(AnimationUtils.loadAnimation(context, R.anim.mainactivity_push_bottom_in));
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Btn_run_errands.setVisibility(View.VISIBLE);
                Btn_run_errands.startAnimation(AnimationUtils.loadAnimation(context, R.anim.mainactivity_push_bottom_in));
            }
        }, 100);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Btn_nearby.setVisibility(View.VISIBLE);
                Btn_nearby.startAnimation(AnimationUtils.loadAnimation(context, R.anim.mainactivity_push_bottom_in));
            }
        }, 200);
    }


    /**
     * 取消对话框（带动画）
     */
    public void outputDialog() {
        //退出动画
        rlMain.startAnimation(AnimationUtils.loadAnimation(context, R.anim.mainactivity_fade_out));
        ivMenu.startAnimation(AnimationUtils.loadAnimation(context, R.anim.mainactivity_rotate_left));
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                dismiss();
            }
        }, 400);
        Btn_new_things.startAnimation(AnimationUtils.loadAnimation(context, R.anim.mainactivity_push_bottom_out));
        Btn_new_things.setVisibility(View.INVISIBLE);
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                Btn_run_errands.startAnimation(AnimationUtils.loadAnimation(context, R.anim.mainactivity_push_bottom_out));
                Btn_run_errands.setVisibility(View.INVISIBLE);
            }
        }, 50);
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                Btn_nearby.startAnimation(AnimationUtils.loadAnimation(context, R.anim.mainactivity_push_bottom_out));
                Btn_nearby.setVisibility(View.INVISIBLE);
            }
        }, 100);

    }


    @Override
    public void show() {
        super.show();
        inputDialog();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //全屏
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
    }
    
    public PublishDialog setBtn_new_thingsclicklistener(View.OnClickListener clickListener){
        Btn_new_things.setOnClickListener(clickListener);
        return this;
    }

    public PublishDialog setBtn_run_errandsclicklistener(View.OnClickListener clickListener){
        Btn_run_errands.setOnClickListener(clickListener);
        return this;
    }

    public PublishDialog setBtn_nearbyclicklistener(View.OnClickListener clickListener){
        Btn_nearby.setOnClickListener(clickListener);
        return this;
    }
}