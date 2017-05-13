package com.sdyhlt.duoyuan.apptestmvp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sdyhlt.duoyuan.apptestmvp.R;
import com.sdyhlt.duoyuan.apptestmvp.bean.HuoChebean;

import java.util.List;

/**
 * Created by jingsheng on 2017/2/9.
 */

public class TrainListAdapter extends BaseAdapter {
    private List<HuoChebean.ResultBean> list;
    private Context context;

    public TrainListAdapter(List<HuoChebean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodleTrain vh;
        if (convertView==null){
            vh=new ViewHodleTrain();
            convertView=View.inflate(context,R.layout.itme_huoche_01,null);
            vh.setID(convertView);
            convertView.setTag(vh);
        }else {
            vh= (ViewHodleTrain) convertView.getTag();
        }
        vh.mTvstartStationName.setText(list.get(position).getStartStationName()==null?list.get(position).getStationName():list.get(position).getStartStationName());
        vh.mTvendStationName.setText(list.get(position).getEndStationName());
        vh.mTvstartTime.setText(list.get(position).getStartTime());
        vh.mTvarriveTime.setText(list.get(position).getArriveTime());
        vh.mTvstationTrainCode.setText(list.get(position).getStationTrainCode());
        vh.mTvpriceed.setText(list.get(position).getPricewz()==null?list.get(position).getPricerw():list.get(position).getPricewz()+"起");
        vh.mTvstopoverTime.setText(list.get(position).getLishi()==null?"停"+list.get(position).getStopoverTime():list.get(position).getLishi());
        return convertView;
    }
    private class ViewHodleTrain{
        private TextView mTvstartStationName,mTvendStationName,mTvstopoverTime,mTvstationTrainCode,mTvarriveTime,mTvstartTime,mTvpriceed;
        private void setID(View v){
            mTvstartStationName= (TextView) v.findViewById(R.id.zd_shifa);
            mTvendStationName= (TextView) v.findViewById(R.id.zd_zhong_dian);
            mTvstopoverTime= (TextView) v.findViewById(R.id.time_ting);
            mTvstartTime= (TextView) v.findViewById(R.id.time_chufa);
            mTvarriveTime= (TextView) v.findViewById(R.id.time_daoda);
            mTvpriceed= (TextView) v.findViewById(R.id.price_train);

            mTvstationTrainCode=(TextView) v.findViewById(R.id.train_name);

        }

    }
}
