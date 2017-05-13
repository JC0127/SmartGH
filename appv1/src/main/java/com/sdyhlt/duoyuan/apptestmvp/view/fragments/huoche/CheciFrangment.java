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

public class CheciFrangment extends BaseFragment {

    private Button button;
    private EditText editText;
    @Override
    protected int getLayout() {
        return R.layout.huoche_select_itme02;
    }

    @Override
    protected void initView(View view) {
        editText= (EditText) view.findViewById(R.id.et_c);
        button= (Button) view.findViewById(R.id.btn_02);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=editText.getText().toString().trim();
                if (TextUtils.isEmpty(a)){
                    Toast.makeText(getActivity(), "请输入完整", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent=new Intent(getActivity(), ItemSelectZD.class);
                intent.putExtra("A",a);
                startActivity(intent);
            }
        });

    }
}
