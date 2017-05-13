package com.sdyhlt.duoyuan.apptestmvp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sdyhlt.duoyuan.apptestmvp.R;
import com.sdyhlt.duoyuan.apptestmvp.bean.ShehuiBeans;

import java.util.List;

/**
 * Created by jingsheng on 2016/12/30.
 */

public class ShehuiAdapter extends BaseAdapter {

    private Context context;
    private List<ShehuiBeans.ResultBean.DataBean> list;

    final int TYPE_1 = 0;
    final int TYPE_2 = 1;

    public ShehuiAdapter(Context context, List<ShehuiBeans.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
//        Log.e("getCount",list.size()+"*******");
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //多布局


    @Override
    public int getItemViewType(int position) {
//        return super.getItemViewType(position);

        if ((position + 1) % 3 == 0) {
            return TYPE_1;
        } else {
            return TYPE_2;
        }

    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHodle1 vh1;
        ViewHodel2 vh2;

        int type = getItemViewType(position);

        switch (type) {

            case TYPE_1:

                if (convertView == null) {
                    convertView = View.inflate(context, R.layout.shehui_news_item, null);
                    vh1 = new ViewHodle1();
                    vh1.setID(convertView);
                    convertView.setTag(vh1);
                } else {
                    vh1 = (ViewHodle1) convertView.getTag();
                }
                vh1.mTvTitle.setText(list.get(position).getTitle());
                vh1.mTvType.setText("《" + list.get(position).getAuthor_name() + "》");
                vh1.mTvTime.setText(list.get(position).getDate());
                Glide.with(context).load(list.get(position).getThumbnail_pic_s()).into(vh1.mImageView);

                break;

            case TYPE_2:

                if (convertView == null) {
                    convertView = View.inflate(context, R.layout.top_newsews_itme, null);
                    vh2 = new ViewHodel2();
                    vh2.setId(convertView);
                    convertView.setTag(vh2);
                } else {
                    vh2 = (ViewHodel2) convertView.getTag();
                }

                Glide.with(context).load(list.get(position).getThumbnail_pic_s()).error(R.mipmap.ic_launcher).into(vh2.imageView);


//        vh.imageView.setImageResource(R.mipmap.ic_launcher);
                vh2.text.setText(list.get(position).getTitle());
                vh2.other.setText(list.get(position).getCategory());
                vh2.typy.setText(list.get(position).getAuthor_name());
                vh2.time.setText(list.get(position).getDate());

                break;
            default:
                break;

        }


        return convertView;
    }

    class ViewHodle1 {
        private TextView mTvTitle, mTvType, mTvTime;
        private ImageView mImageView;

        public void setID(View view) {
            mTvTitle = (TextView) view.findViewById(R.id.tv_shehui_title);
            mTvType = (TextView) view.findViewById(R.id.tv_shehui_type);
            mTvTime = (TextView) view.findViewById(R.id.tv_shehui_time);
            mImageView = (ImageView) view.findViewById(R.id.iv_shehui);
        }
    }

    class ViewHodel2 {
        ImageView imageView;
        TextView text, time, typy, other;

        void setId(View view) {
            imageView = (ImageView) view.findViewById(R.id.imageView);
            text = (TextView) view.findViewById(R.id.text);
            time = (TextView) view.findViewById(R.id.tv_mvp_time);
            typy = (TextView) view.findViewById(R.id.type);
            other = (TextView) view.findViewById(R.id.othor);

        }

    }
}
