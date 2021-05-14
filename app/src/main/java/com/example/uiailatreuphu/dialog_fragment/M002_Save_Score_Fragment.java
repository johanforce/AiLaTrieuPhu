package com.example.uiailatreuphu.dialog_fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.example.uiailatreuphu.R;
import com.example.uiailatreuphu.entities.Score;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class M002_Save_Score_Fragment extends DialogFragment implements View.OnClickListener {
    public static final String TAG= M002_Save_Score_Fragment.class.getName();
    public static final String KEY_LISTSCORE = "KEY_LISTSCORE";
    private TextView tvSaveScore;
    private EditText etSaveScore;
    private Button btSaveScore;
    private ArrayList<Score> listScore= new ArrayList<>();
    private int score;
    private int scoreFinal;
    private boolean isHelpStop;

    public M002_Save_Score_Fragment(int score, boolean isHelpStop) {
        this.isHelpStop=isHelpStop;
        this.score = score;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.m002_frg_savescore, container, false);
        getDialog().setTitle("Seyirci Joker");

        tvSaveScore=view.findViewById(R.id.tv_scoreSave);
        etSaveScore=view.findViewById(R.id.et_nameSave);

        if(isHelpStop==true){
            scoreFinal=score;
        }
        else if(isHelpStop==false){
            if(score<2000000){
                scoreFinal=0;
            }else if(score>=2000000&&score<22000000){
                scoreFinal=2000000;
            }else if(score>=22000000&&score<150000000){
                scoreFinal=22000000;
            }else if(score==150000000){
                scoreFinal=150000000;
            }
        }

        tvSaveScore.setText("Số điểm của bạn là:"+ scoreFinal+" VNĐ");
        Score score= new Score(etSaveScore.getText().toString(),scoreFinal);
        view.findViewById(R.id.bt_saveScore).setOnClickListener(this);

//        SharedPreferences sharedPref = getContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
//        int x= sharedPref.getInt("score",0);
//        if(x<=scoreFinal) {
//            SharedPreferences sharedNext = getContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
//            SharedPreferences.Editor editor = sharedNext.edit();
//            editor.putString("name", etSaveScore.getText().toString());
//            editor.putInt("score", scoreFinal);
//            editor.apply();
//        }
        SharedPreferences prefs = getContext().getSharedPreferences("MyPreferences2", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String response=prefs.getString(M002_Save_Score_Fragment.KEY_LISTSCORE, "");
        ArrayList<Score> lstArrayList = gson.fromJson(response,
                new TypeToken<List<Score>>(){}.getType());
        lstArrayList.add(score);
        lstArrayList.remove(6);

        SharedPreferences sharedPref = getContext().getSharedPreferences("MyPreferences2", Context.MODE_PRIVATE);
        ArrayList<Score> list= lstArrayList;
        Gson gson1 = new Gson();
        String json = gson1.toJson(list);

        SharedPreferences.Editor editor= sharedPref.edit();
        editor.remove(KEY_LISTSCORE).commit();
        editor.putString(KEY_LISTSCORE, json);
        editor.commit();

        return view;
    }


    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.bt_saveScore){
               getDialog().dismiss();
               getActivity().finish();
           }
        }
}
