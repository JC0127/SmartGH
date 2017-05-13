package com.sdyhlt.duoyuan.apptestmvp.view.fragments.huoche;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sdyhlt.duoyuan.apptestmvp.R;
import com.sdyhlt.duoyuan.apptestmvp.base.BaseFragment;
import com.sdyhlt.duoyuan.apptestmvp.view.ItemSelectZD;

/**
 * Created by jingsheng on 2017/2/8.
 */

public class ZhanDainFrangment extends BaseFragment implements View.OnClickListener {
    private EditText editText_a,editText_b;
    private Button mBtn,mBtnCahnge;
    @Override
    protected int getLayout() {
        return R.layout.huoche_select_itme01;
    }

    @Override
    protected void initView(View view) {
        editText_a= (EditText) view.findViewById(R.id.et_a);
        editText_b= (EditText) view.findViewById(R.id.et_b);
        mBtn= (Button) view.findViewById(R.id.btn_01);
        mBtnCahnge= (Button) view.findViewById(R.id.change);
        mBtnCahnge.setOnClickListener(this);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=editText_a.getText().toString().trim();
                String b = editText_b.getText().toString().trim();
                if (TextUtils.isEmpty(a)||TextUtils.isEmpty(b)){
                    Toast.makeText(getActivity(), "请输入完整", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent=new Intent(getActivity(), ItemSelectZD.class);

                intent.putExtra("A",a);
                intent.putExtra("B",b);
                startActivity(intent);
//                getActivity().overridePendingTransition(R.anim.design_fab_in, R.anim.design_fab_in);
            }
        });
    }

    @Override
    public void onClick(View v) {
        String a=editText_a.getText().toString().trim();
        String b = editText_b.getText().toString().trim();
        String tem;
        tem=a;
        a=b;
        b=tem;
        editText_a.setText(a);
        editText_b.setText(b);
    }
}
