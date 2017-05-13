package com.sdyhlt.duoyuan.apptestmvp.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sdyhlt.duoyuan.apptestmvp.R;
import com.sdyhlt.duoyuan.apptestmvp.bean.WeixinBeans;
import com.sdyhlt.duoyuan.apptestmvp.view.NewsInfo;

import java.util.List;

/**
 * Created by jingsheng on 2017/1/3.
 */

public class WeixinAdapter extends BaseAdapter {
    List<List<WeixinBeans.ResultBean.ListBean>> list;
    private Context context;

    public WeixinAdapter(List<List<WeixinBeans.ResultBean.ListBean>> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        Log.e("list.size()",list.size()+"");
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHoderWX vh;

        if (convertView==null){
            convertView=View.inflate(context,R.layout.weixin_itme,null);
            vh=new ViewHoderWX();
            vh.setId(convertView);
            convertView.setTag(vh);
        }else {
            vh= (ViewHoderWX) convertView.getTag();
        }
        Log.e("position",position+"");
        Glide.with(context).load(list.get(position).get(0).getFirstImg()).into(vh.iv0);
        Glide.with(context).load(list.get(position).get(1).getFirstImg()).into(vh.iv1);
        Glide.with(context).load(list.get(position).get(2).getFirstImg()).into(vh.iv2);
        Glide.with(context).load(list.get(position).get(3).getFirstImg()).into(vh.iv3);
        Glide.with(context).load(list.get(position).get(4).getFirstImg()).into(vh.iv4);

        vh.tv0.setText(list.get(position).get(0).getTitle());
        vh.tv1.setText(list.get(position).get(1).getTitle());
        vh.tv2.setText(list.get(position).get(2).getTitle());
        vh.tv3.setText(list.get(position).get(3).getTitle());
        vh.tv4.setText(list.get(position).get(4).getTitle());
        vh.layout0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, NewsInfo.class);
                intent.putExtra("url",list.get(position).get(0).getUrl());
                intent.putExtra("title",list.get(position).get(0).getTitle());
                intent.putExtra("img",list.get(position).get(0).getFirstImg());
                context.startActivity(intent);
            }
        });
        vh.layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.e("url_img",list.get(1).getUrl());
                Intent intent=new Intent(context, NewsInfo.class);
                intent.putExtra("url",list.get(position).get(1).getUrl());
                intent.putExtra("title",list.get(position).get(1).getTitle());
                intent.putExtra("img",list.get(position).get(1).getFirstImg());
                context.startActivity(intent);
            }
        });
        vh.layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, NewsInfo.class);
                intent.putExtra("url",list.get(position).get(2).getUrl());
                intent.putExtra("title",list.get(position).get(2).getTitle());
                intent.putExtra("img",list.get(position).get(2).getFirstImg());
                context.startActivity(intent);
            }
        });
        vh.layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, NewsInfo.class);
                intent.putExtra("url",list.get(position).get(3).getUrl());
                intent.putExtra("title",list.get(position).get(3).getTitle());
                intent.putExtra("img",list.get(position).get(3).getFirstImg());
                context.startActivity(intent);
            }
        });
        vh.layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, NewsInfo.class);
                intent.putExtra("url",list.get(position).get(4).getUrl());
                intent.putExtra("title",list.get(position).get(4).getTitle());
                intent.putExtra("img",list.get(position).get(4).getFirstImg());
                context.startActivity(intent);
            }
        });


        return convertView;
    }



    class ViewHoderWX{
        private ImageView iv0,iv1,iv2,iv3,iv4;
        private TextView tv0,tv1,tv2,tv3,tv4;
        private RelativeLayout layout0;
        private LinearLayout layout1,layout2,layout3,layout4;

        public void setId(View view){
            tv0= (TextView) view.findViewById(R.id.tv_wx_01);
            tv1= (TextView) view.findViewById(R.id.tv_wx_02);
            tv2= (TextView) view.findViewById(R.id.tv_wx_03);
            tv3= (TextView) view.findViewById(R.id.tv_wx_04);
            tv4= (TextView) view.findViewById(R.id.tv_wx_05);
            iv0= (ImageView) view.findViewById(R.id.iv_wx_01);
            iv1= (ImageView) view.findViewById(R.id.iv_wx_02);
            iv2= (ImageView) view.findViewById(R.id.iv_wx_03);
            iv3= (ImageView) view.findViewById(R.id.iv_wx_04);
            iv4= (ImageView) view.findViewById(R.id.iv_wx_05);

            layout0= (RelativeLayout) view.findViewById(R.id.layout_01);
            layout1= (LinearLayout) view.findViewById(R.id.layout_02);
            layout2= (LinearLayout) view.findViewById(R.id.layout_03);
            layout3= (LinearLayout) view.findViewById(R.id.layout_04);
            layout4= (LinearLayout) view.findViewById(R.id.layout_05);

        }

    }
}
