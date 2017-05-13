package com.sdyhlt.duoyuan.apptestmvp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sdyhlt.duoyuan.apptestmvp.R;
import com.sdyhlt.duoyuan.apptestmvp.bean.ShehuiBeans;
import com.sdyhlt.duoyuan.apptestmvp.bean.TopNews;

import java.util.List;

/**
 * Created by jingsheng on 2016/12/25.
 */

public class TheMostAdapter extends BaseAdapter {
    private Context context;
    private List<ShehuiBeans.ResultBean.DataBean> data;

    public TheMostAdapter(Context context, List<ShehuiBeans.ResultBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        Log.e("size",data.size()+"");
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHodel vh;
        if (convertView==null){
            convertView=View.inflate(context, R.layout.top_newsews_itme,null);
            vh=new ViewHodel();
            vh.setId(convertView);
            convertView.setTag(vh);
        }else {
            vh= (ViewHodel) convertView.getTag();
        }

//        OkHttpUtils.get().url(data.get(position).getThumbnail_pic_s()).build().execute(new BitmapCallback() {
//            @Override
//            public void onError(Call call, Exception e, int id) {
//                Toast.makeText(context, "onError", Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onResponse(Bitmap response, int id) {
//                Toast.makeText(context, id+"", Toast.LENGTH_SHORT).show();
//                vh.imageView.setImageBitmap(response);
//            }
//        });

        Glide.with(context).load(data.get(position).getThumbnail_pic_s()).into(vh.imageView);

//        vh.imageView.setImageResource(R.mipmap.ic_launcher);
        vh.text.setText(data.get(position).getTitle());
        vh.other.setText(data.get(position).getCategory());
        vh.typy.setText(data.get(position).getAuthor_name());
        vh.time.setText(data.get(position).getDate());
        return convertView;
    }

    class ViewHodel{
        ImageView imageView;
        TextView text,time,typy,other;
        void setId(View view){
            imageView= (ImageView) view.findViewById(R.id.imageView);
            text= (TextView) view.findViewById(R.id.text);
            time= (TextView) view.findViewById(R.id.tv_mvp_time);
            typy= (TextView) view.findViewById(R.id.type);
            other= (TextView) view.findViewById(R.id.othor);

        }

    }
}
