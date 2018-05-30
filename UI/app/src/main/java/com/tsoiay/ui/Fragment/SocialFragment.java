package com.tsoiay.ui.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.tsoiay.ui.R;

public class SocialFragment extends Fragment {

    private Context mContext;
    private Button btn_back = null;
    private Button btn_edit = null;
    private TextView tv_title = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.social_fragment, container, false);
        btn_back = (Button)view.findViewById(R.id.btnBack);
        btn_edit = (Button)view.findViewById(R.id.btnEdit);
        tv_title = (TextView)view.findViewById(R.id.tv_title);
        InitTitleBar();
        /*
         * 代
         * 码
         * 区
         * */
        return view;
    }

    private void InitTitleBar(){
        btn_back.setVisibility(View.INVISIBLE);
        btn_edit.setVisibility(View.INVISIBLE);
        tv_title.setText("社交");
    }
}
