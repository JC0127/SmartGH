package com.sdyhlt.duoyuan.apptestmvp.view;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.sdyhlt.duoyuan.apptestmvp.R;

public class WellcomeXml extends AppCompatActivity {
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_wellcome_xml);
        layout = (LinearLayout) findViewById(R.id.activity_wellcome_xml);
        ObjectAnimator.ofFloat(layout, "alpha", 0, 1).setDuration(1800).start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WellcomeXml.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2500);
    }

    public void onClick(View view) {
        finish();
    }
}
