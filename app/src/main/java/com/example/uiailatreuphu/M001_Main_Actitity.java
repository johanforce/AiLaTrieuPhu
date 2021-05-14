package com.example.uiailatreuphu;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class M001_Main_Actitity extends AppCompatActivity implements View.OnClickListener {
    private ImageView iv_play, iv_archiver;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m001_main_activity);

        initView();

    }

    private void initView() {
        iv_play=findViewById(R.id.iv_play_menu);
        iv_play.setOnClickListener(this);

        iv_archiver=findViewById(R.id.iv_home_archivement);
        iv_archiver.setOnClickListener(this);

//        mediaPlayer= MediaPlayer.create(this, R.raw.bgmusic);
//        mediaPlayer.start();
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.iv_play_menu){
            iv_play.getDrawable().setLevel(1);
            Intent intent= new Intent(M001_Main_Actitity.this,M002_Play_Actitity.class);
            startActivity(intent);
//            mediaPlayer.stop();
        }
        if(view.getId()==R.id.iv_home_archivement){
            Intent intent= new Intent(M001_Main_Actitity.this,M003_HighScore.class);
            startActivity(intent);
        }
    }

    int x=0;
    @Override
    public void onBackPressed() {
        x++;
        if(x>1) {
//            super.onBackPressed();
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory( Intent.CATEGORY_HOME );
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
            finish();
        }else{
            Toast.makeText(this,"Moi nhap them 1 lan nua",Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    x=0;
                }
            },2000);
        }
    }
}