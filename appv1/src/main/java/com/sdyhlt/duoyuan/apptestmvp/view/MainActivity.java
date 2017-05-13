package com.sdyhlt.duoyuan.apptestmvp.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.sdyhlt.duoyuan.apptestmvp.R;
import com.sdyhlt.duoyuan.apptestmvp.view.fragments.HomeFragment;
import com.sdyhlt.duoyuan.apptestmvp.view.fragments.RobotFragment;
import com.sdyhlt.duoyuan.apptestmvp.view.fragments.VideoFragment;
import com.sdyhlt.duoyuan.apptestmvp.view.fragments.WeixinNewsFragment;

public class MainActivity extends AppCompatActivity{
    private ListView view;

    private FrameLayout frameLayout;
    private FragmentManager manager;
    private Fragment mFragment,mFragmentWeixin,mFragmentRobot,mFragmentMove;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        frameLayout= (FrameLayout) findViewById(R.id.temp_layout);
        mRadioGroup= (RadioGroup) findViewById(R.id.rb_group);
        mRadioButton= (RadioButton) findViewById(R.id.rb_news);
        manager=getSupportFragmentManager();
        if (mFragment==null){
            mFragment=new HomeFragment();
            manager.beginTransaction().replace(R.id.temp_layout,mFragment).commit();

        }
        mRadioButton.setChecked(true);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                Toast.makeText(MainActivity.this, checkedId+"", Toast.LENGTH_SHORT).show();
                switch (checkedId){
                    case R.id.rb_news:
                        reShows();
                        if (mFragment==null){
                            mFragment=new HomeFragment();
                            manager.beginTransaction().add(R.id.temp_layout,mFragment).commit();
                        }else {
                            manager.beginTransaction().show(mFragment).commit();
                        }

                        break;
                    case R.id.rb_wexin:
                        reShows();
                        if (mFragmentWeixin==null){
                            mFragmentWeixin=new WeixinNewsFragment();
                            manager.beginTransaction().add(R.id.temp_layout,mFragmentWeixin).commit();
                        }else {
                            manager.beginTransaction().show(mFragmentWeixin).commit();
                        }
                        break;
                    case R.id.rb_robot:
                        reShows();
                        if (mFragmentRobot==null){
                            mFragmentRobot=new RobotFragment();
                            manager.beginTransaction().add(R.id.temp_layout,mFragmentRobot).commit();
                        }else {
                            manager.beginTransaction().show(mFragmentRobot).commit();
                        }
                        break;
                    case R.id.rb_move:
                        reShows();
                        if (mFragmentMove==null){
                            mFragmentMove=new VideoFragment();
                            manager.beginTransaction().add(R.id.temp_layout,mFragmentMove).commit();
                        }else {
                            manager.beginTransaction().show(mFragmentMove).commit();
                        }
                        break;

                    default:
                        break;

                }

            }
        });


//        new NewsPresenter(this).fetch();
    }


    private void reShows(){
        if (mFragment!=null){
            manager.beginTransaction().hide(mFragment).commit();
        }
        if (mFragmentWeixin!=null){
            manager.beginTransaction().hide(mFragmentWeixin).commit();
        }
        if (mFragmentRobot!=null){
            manager.beginTransaction().hide(mFragmentRobot).commit();
        }
        if (mFragmentMove!=null){
            manager.beginTransaction().hide(mFragmentMove).commit();
        }
    }


}
