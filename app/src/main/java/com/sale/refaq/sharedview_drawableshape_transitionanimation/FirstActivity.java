package com.sale.refaq.sharedview_drawableshape_transitionanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    LinearLayout backgroundLl;
    Button goToBtn;
    TextView headlineTv;
    ImageView profileIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        goToBtn = findViewById(R.id.goToBtn);
        backgroundLl = findViewById(R.id.backgroundLl);
        profileIv = findViewById(R.id.profileIv);
        headlineTv = findViewById(R.id.headlineTv);

        goToBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent to go to second activity
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);

                //init pairs which transition apply
                Pair[] pairs = new Pair[3]; //we will apply [3] transition so 3 index
                pairs[0] = new Pair<View,String>(backgroundLl,"background_linear");//we must determine index
                pairs[1] = new Pair<View,String>(headlineTv,"headline_text");//we must determine index
                pairs[2] = new Pair<View,String>(profileIv,"profile_image");//we must determine index

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(FirstActivity.this,pairs);
                    startActivity(intent,options.toBundle());
                }else
                    startActivity(intent);
            }
        });
    }
}
