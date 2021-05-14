package com.example.uiailatreuphu;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uiailatreuphu.dialog_fragment.M002_Save_Score_Fragment;
import com.example.uiailatreuphu.entities.Score;
import com.example.uiailatreuphu.entities.ScoreComparator;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class M003_HighScore extends AppCompatActivity {
    private TextView tvName1, tvScore1,tvName2, tvScore2,tvName3, tvScore3,tvName4, tvScore4,tvName5, tvScore5;
    private ArrayList<Score> listScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m003__high_score_activity);

            initView();
    }

    private void initView(){
            tvName1=findViewById(R.id.tv_nameShow1);
            tvScore1=findViewById(R.id.tv_scoreShow1);
            tvName2=findViewById(R.id.tv_nameShow2);
            tvScore2=findViewById(R.id.tv_scoreShow2);
            tvName3=findViewById(R.id.tv_nameShow3);
            tvScore3=findViewById(R.id.tv_scoreShow3);
            tvName4=findViewById(R.id.tv_nameShow4);
            tvScore4=findViewById(R.id.tv_scoreShow4);
            tvName5=findViewById(R.id.tv_nameShow5);
            tvScore5=findViewById(R.id.tv_scoreShow5);
//        tvName=findViewById(R.id.tv_nameShow1);
//        tvScore=findViewById(R.id.tv_scoreShow1);
//
//        SharedPreferences sharedPref = this.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
//        int x= sharedPref.getInt("score",0);
//        String y= sharedPref.getString("name","");
//        tvScore.setText(""+x);
//        tvName.setText(y);

        SharedPreferences prefs = getSharedPreferences("MyPreferences2", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String response=prefs.getString(M002_Save_Score_Fragment.KEY_LISTSCORE, "");
        ArrayList<Score> lstArrayList = gson.fromJson(response,
                new TypeToken<List<Score>>(){}.getType());
        Collections.sort(lstArrayList,new ScoreComparator());
        tvName1.setText(lstArrayList.get(0).getName());
        tvScore1.setText(lstArrayList.get(0).getScore()+"");
        tvName2.setText(lstArrayList.get(1).getName());
        tvScore2.setText(lstArrayList.get(1).getScore()+"");
        tvName3.setText(lstArrayList.get(2).getName());
        tvScore3.setText(lstArrayList.get(2).getScore()+"");
        tvName4.setText(lstArrayList.get(3).getName());
        tvScore4.setText(lstArrayList.get(3).getScore()+"");
        tvName5.setText(lstArrayList.get(4).getName());
        tvScore5.setText(lstArrayList.get(4).getScore()+"");
    }
}