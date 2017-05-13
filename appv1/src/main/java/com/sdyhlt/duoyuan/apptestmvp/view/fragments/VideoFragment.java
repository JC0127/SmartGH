package com.sdyhlt.duoyuan.apptestmvp.view.fragments;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.sdyhlt.duoyuan.apptestmvp.R;
import com.sdyhlt.duoyuan.apptestmvp.base.BaseFragment;
import com.sdyhlt.duoyuan.apptestmvp.bean.WeatherBeans;
import com.sdyhlt.duoyuan.apptestmvp.presenter.WeathrP;
import com.sdyhlt.duoyuan.apptestmvp.view.interfaces.IweatherView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by jingsheng on 2016/12/28.
 */

public class VideoFragment extends BaseFragment implements IweatherView{
    private TextView tvCyti,tvWendu,tvTanqi;
    private Button btn;
    private static final String city[]={"济南","青岛","淄博","枣庄","东营","烟台","潍坊","济宁"
            ,"泰安","威海","日照","滨州","德州","聊城","临沂","菏泽","莱芜"};
    private Spinner spinner;
    Dialog dialog;
    @Override
    protected int getLayout() {
        return R.layout.weather_layout;
    }

    @Override
    protected void initView(View view) {
        tvCyti= (TextView) view.findViewById(R.id.city);
        tvTanqi= (TextView) view.findViewById(R.id.tianqi);
        tvWendu= (TextView) view.findViewById(R.id.wendu);
        btn= (Button) view.findViewById(R.id.btn_shuaxin);
        spinner= (Spinner) view.findViewById(R.id.sp);
        dialog=new ProgressDialog(getActivity());
        dialog.setTitle("拉取数据");

        new WeathrP(VideoFragment.this,getActivity()).fetch(city[2]);
        dialog.show();

//        spinner.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        spinner.setSelection(2);

//        String hostIP = getHostIP();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new WeathrP(VideoFragment.this,getActivity()).fetch(city[spinner.getLastVisiblePosition()]);
                dialog.show();
            }
        });



    }

    @Override
    public void showView(List<WeatherBeans.ResultBean> listBeen) {
        dialog.hide();
        tvCyti.setText(listBeen.get(0).getCity());
        tvWendu.setText(listBeen.get(0).getTemperature());
        tvTanqi.setText(listBeen.get(0).getWeather());

    }

    @Override
    public void showError() {
        dialog.hide();

    }

    public String getHostIP() {
        String hostIp = null;
        try {
            Enumeration nis = NetworkInterface.getNetworkInterfaces();
            InetAddress ia = null;
            while (nis.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) nis.nextElement();
                Enumeration<InetAddress> ias = ni.getInetAddresses();
                while (ias.hasMoreElements()) {
                    ia = ias.nextElement();
                    if (ia instanceof Inet6Address) {
                        continue;// skip ipv6
                    }
                    String ip = ia.getHostAddress();
                    if (!"127.0.0.1".equals(ip)) {
                        hostIp = ia.getHostAddress();
                        break;
                    }
                }
            }
        } catch (SocketException e) {
            Log.i("yao", "SocketException");
            e.printStackTrace();
        }
        new WeathrP(VideoFragment.this,getActivity()).fetch(hostIp);
        return hostIp;
    }


}
