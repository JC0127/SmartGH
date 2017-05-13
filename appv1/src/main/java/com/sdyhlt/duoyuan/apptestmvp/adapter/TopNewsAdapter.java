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
import com.sdyhlt.duoyuan.apptestmvp.bean.TopNews;

import java.util.List;

/**
 * Created by jingsheng on 2016/12/25.
 */

public class TopNewsAdapter extends BaseAdapter {
    private Context context;
    private List<TopNews.ResultBean.DataBean> data;

    public TopNewsAdapter(Context context, List<TopNews.ResultBean.DataBean> data) {
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
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {

        if (position==0){
            return 0;
        }else if (position==3){
            return 1;
        }else{
            return 2;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHodel vh;
        ViewHoders2 vh2;
        ViewHodlers3 vh3;

        int type=getItemViewType(position);

        if (type==0){
            if (convertView==null){
                convertView=View.inflate(context, R.layout.top_news_item2,null);
                vh2=new ViewHoders2();
                vh2.setId(convertView);
                convertView.setTag(vh2);
            }else {
                vh2= (ViewHoders2) convertView.getTag();
            }

            vh2.text.setText(data.get(position).getTitle());
            Glide.with(context).load(data.get(position).getThumbnail_pic_s()).into(vh2.imageView);



        }
        if (type==1){
            if (convertView==null){
                convertView=View.inflate(context, R.layout.shehui_news_item,null);
                vh3=new ViewHodlers3();
                vh3.setID(convertView);
                convertView.setTag(vh3);
            }else {
                vh3= (ViewHodlers3) convertView.getTag();
            }
            vh3.mTvTitle.setText(data.get(position).getTitle());
            vh3.mTvType.setText("《"+data.get(position).getAuthor_name()+"》");
            vh3.mTvTime.setText(data.get(position).getDate());
            Glide.with(context).load(data.get(position).getThumbnail_pic_s()).into(vh3.mImageView);


        }
        if (type==2){
            if (convertView==null){
                convertView=View.inflate(context, R.layout.top_newsews_itme,null);
                vh=new ViewHodel();
                vh.setId(convertView);
                convertView.setTag(vh);
            }else {
                vh= (ViewHodel) convertView.getTag();
            }
            Glide.with(context).load(data.get(position).getThumbnail_pic_s()).into(vh.imageView);

//        vh.imageView.setImageResource(R.mipmap.ic_launcher);
            vh.text.setText(data.get(position).getTitle());
            vh.other.setText(data.get(position).getType());
            vh.typy.setText(data.get(position).getAuthor_name());
            vh.time.setText(data.get(position).getDate());


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
    class ViewHoders2{
        ImageView imageView;
        TextView text;
        void setId(View view){
            imageView= (ImageView) view.findViewById(R.id.iv_top_shehui);
            text= (TextView) view.findViewById(R.id.tv_top2_title);
        }
    }
    class ViewHodlers3{
        private TextView mTvTitle,mTvType,mTvTime;
        private ImageView mImageView;
        public void setID(View view){
            mTvTitle= (TextView) view.findViewById(R.id.tv_shehui_title);
            mTvType= (TextView) view.findViewById(R.id.tv_shehui_type);
            mTvTime= (TextView) view.findViewById(R.id.tv_shehui_time);
            mImageView= (ImageView) view.findViewById(R.id.iv_shehui);
        }
    }
}
