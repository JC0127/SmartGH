package com.sdyhlt.duoyuan.apptestmvp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sdyhlt.duoyuan.apptestmvp.R;
import com.sdyhlt.duoyuan.apptestmvp.adapter.TrainListAdapter;
import com.sdyhlt.duoyuan.apptestmvp.bean.HuoChebean;
import com.sdyhlt.duoyuan.apptestmvp.presenter.TrainZDpresenter;
import com.sdyhlt.duoyuan.apptestmvp.view.interfaces.IItemSelectZd;

import java.util.List;

public class ItemSelectZD extends AppCompatActivity implements IItemSelectZd {
    private TrainListAdapter mAdapter;
    private List<HuoChebean.ResultBean> list;
    private ListView mLv;
    private TextView mTvStart,mTvEnd;
    private Button btnC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_item_select_zd);
        mLv = (ListView) findViewById(R.id.lv_zd);
        mTvStart= (TextView) findViewById(R.id.tv_start_01);
        mTvEnd= (TextView) findViewById(R.id.tv_end_01);
        btnC= (Button) findViewById(R.id.btn_back01);
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent=getIntent();
        String a = intent.getStringExtra("A");
        String b = intent.getStringExtra("B");

        mTvStart.setText(a);
        mTvEnd.setText(b);

//        Log.e("string",a+b);
        if (!TextUtils.isEmpty(b)){
            new TrainZDpresenter(this).fetch(a,b);
        }else {
            new TrainZDpresenter(this).fetch(a);
        }

    }

    @Override
    public void showInfo(List<HuoChebean.ResultBean> info) {
        mAdapter = new TrainListAdapter(info, this);
        mLv.setAdapter(mAdapter);
    }

    @Override
    public void showError(int type) {
        if (type==0){
            Toast.makeText(this, "请检查网络！", Toast.LENGTH_SHORT).show();
            finish();
        }
        if (type==1){
            Toast.makeText(this, "站点输入不正确！", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
