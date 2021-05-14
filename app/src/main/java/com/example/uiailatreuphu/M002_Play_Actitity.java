package com.example.uiailatreuphu;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uiailatreuphu.dialog_fragment.M002_Audience_Fragment;
import com.example.uiailatreuphu.dialog_fragment.M002_Help_Call_Fragment;
import com.example.uiailatreuphu.dialog_fragment.M002_Help_DapAn_Fragment;
import com.example.uiailatreuphu.dialog_fragment.M002_Save_Score_Fragment;
import com.example.uiailatreuphu.entities.QuestionEntities;

import java.util.Random;

public class M002_Play_Actitity extends AppCompatActivity implements View.OnClickListener {
    private static final String KEY_TRUE = "TRUE_KEY";
    private QuestionEntities questionEntities;
   private Activity activity;
    private int count=1;
    private Thread thread;
    private ProgressBar prTime;
    private TextView tvQuest, tvDetailQuest, tvScore, tvTime;
    private Button tvCaseA, tvCaseB, tvCaseC, tvCaseD;
    private ImageView iv_changeHelp, iv_5050, iv_stop, iv_call, iv_audience;
    private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12,tv13,tv14,tv15;
    private int trueCase;
    private int score;
    private int[] listScore = {0,200000,400000,600000,1000000,2000000,3000000,6000000,10000000,14000000,22000000,30000000,40000000,60000000,85000000,150000000};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m002_play_activity);

        initView();
        initData(count);
    }
    private void initView() {
        tvQuest=findViewById(R.id.tv_quest);
        tvCaseA=findViewById(R.id.tv_dapan1);
        tvCaseB=findViewById(R.id.tv_dapan2);
        tvCaseC=findViewById(R.id.tv_dapan3);
        tvCaseD=findViewById(R.id.tv_dapan4);
        tvDetailQuest=findViewById(R.id.tv_DetailQuest);
        tvScore=findViewById(R.id.tv_score);
        iv_changeHelp=findViewById(R.id.iv_help_change);
        iv_changeHelp.setOnClickListener(this);
        iv_5050=findViewById(R.id.iv_help_5050);
        iv_5050.setOnClickListener(this);
        iv_stop=findViewById(R.id.iv_help_stop);
        iv_stop.setOnClickListener(this);
        iv_call=findViewById(R.id.iv_help_call);
        iv_call.setOnClickListener(this);
        iv_audience= findViewById(R.id.iv_help_audience);
        iv_audience.setOnClickListener(this);
        tvTime=findViewById(R.id.tv_time);
        prTime=findViewById(R.id.prgBar);
        tv1=findViewById(R.id.tv_1);
        tv2=findViewById(R.id.tv_2);
        tv3=findViewById(R.id.tv_3);
        tv4=findViewById(R.id.tv_4);
        tv5=findViewById(R.id.tv_5);
        tv6=findViewById(R.id.tv_6);
        tv7=findViewById(R.id.tv_7);
        tv8=findViewById(R.id.tv_8);
        tv9=findViewById(R.id.tv_9);
        tv10=findViewById(R.id.tv_10);
        tv11=findViewById(R.id.tv_11);
        tv12=findViewById(R.id.tv_12);
        tv13=findViewById(R.id.tv_13);
        tv14=findViewById(R.id.tv_14);
        tv15=findViewById(R.id.tv_15);


        SharedPreferences shared= this.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        if(shared!= null) {
            SharedPreferences.Editor editor = shared.edit();
            editor.putString("name", "");
            editor.putInt("score", 0);
        }
    }

    private void initData(int count) {
            QuestionManager.getInstance().getQuestionById(data -> {
                 runOnUiThread(()->{
                 QuestionEntities questionEntities= (QuestionEntities) data;
                     tvQuest.setText("Câu"+ count+":");
                     tvDetailQuest.setText(questionEntities.getQuestion());
                     tvCaseA.setText(questionEntities.getCaseA());
                     tvCaseB.setText(questionEntities.getCaseB());
                     tvCaseC.setText(questionEntities.getCaseC());
                     tvCaseD.setText(questionEntities.getCaseD());
                     trueCase=questionEntities.getTrueCase();

                     tvCaseA.setOnClickListener(this);
                     tvCaseB.setOnClickListener(this);
                     tvCaseC.setOnClickListener(this);
                     tvCaseD.setOnClickListener(this);
            });},count);
        tvScore.setText(""+listScore[count-1]);
        score=listScore[count-1];
        startProgress();
    }

    private void startProgress() {
//        runOnUiThread(new Runnable() {
//           @Override
//           public void run() {
//               new CountDownTimer(30000, 1000) {
//
//                   public void onTick(long millisUntilFinished) {
//                       tvTime.setText("" + millisUntilFinished / 1000);
//                       prTime.setProgress((int) (millisUntilFinished / 1000));
//                   }
//
//                   public void onFinish() {
//                       Toast.makeText(M002_Play_Actitity.this,"Bạn đã vượt quá thời gian cho phép",Toast.LENGTH_SHORT).show();
//                       finish();
//                   }
//               }.start();
//           }
//       });
        if(thread!=null){
            thread.interrupt();
        }
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    prTime.setProgress(0);
                    for (int i = 1; i <= 30; i++) {
                        final int mI=i;

                        Thread.sleep(1000);
                        runOnUiThread(()->{
                           tvTime.setText(""+mI);
                       });
                        prTime.setProgress(i);
                        if (i == 30) {
                            M002_Save_Score_Fragment m002_save_score_fragment= new M002_Save_Score_Fragment(score,false);
                            m002_save_score_fragment.show(getSupportFragmentManager(), M002_Save_Score_Fragment.TAG);
                        }
                    }
                } catch (InterruptedException e)
                {
                    Thread.currentThread().interrupt(); // restore interrupted status
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_dapan1:
                checkAnswer(1,tvCaseA);
                break;
            case R.id.tv_dapan2:
                checkAnswer(2,tvCaseB);
                break;
            case R.id.tv_dapan3:
                checkAnswer(3,tvCaseC);
                break;
            case R.id.tv_dapan4:
                checkAnswer(4,tvCaseD);
                break;
            case R.id.iv_help_change:
                useChangeHelp();
                break;
            case R.id.iv_help_5050:
                use5050();
                break;
            case R.id.iv_help_stop:
                useStop();
                break;
            case R.id.iv_help_call:
                useCall();
                break;
            case R.id.iv_help_audience:
                useAudience();
                break;
        }
    }

    private void useAudience() {
        if(iv_audience.getDrawable().getLevel()==0) {
            M002_Audience_Fragment m002_audience_fragment = new M002_Audience_Fragment(trueCase);
            m002_audience_fragment.show(getSupportFragmentManager(), M002_Audience_Fragment.TAG);
        }
        iv_audience.getDrawable().setLevel(1);
        iv_audience.setEnabled(false);
    }

    private void useCall() {// Code láo
        if(iv_call.getDrawable().getLevel()==0) {
            M002_Help_DapAn_Fragment m002_help_dapAn_fragment = new M002_Help_DapAn_Fragment(trueCase);
            m002_help_dapAn_fragment.show(getSupportFragmentManager(), M002_Help_DapAn_Fragment.TAG);
            M002_Help_Call_Fragment m002_help_call_fragment = new M002_Help_Call_Fragment(trueCase);
            m002_help_call_fragment.show(getSupportFragmentManager(), M002_Help_Call_Fragment.TAG);
        }
        iv_call.getDrawable().setLevel(1);
        iv_call.setEnabled(false);
    }

    private void useStop() {
        if(iv_stop.getDrawable().getLevel()==0) {
//            isHelpStop=true;
            M002_Save_Score_Fragment m002_save_score_fragment= new M002_Save_Score_Fragment(score,true);
            m002_save_score_fragment.show(getSupportFragmentManager(), M002_Save_Score_Fragment.TAG);
        }
        iv_stop.getDrawable().setLevel(1);
    }

    private void use5050() {
        if(iv_5050.getDrawable().getLevel()==0) {
            Random random = new Random();
            int x = random.nextInt(3) + 1;
            int y = random.nextInt(3) + 1;
            if (x == trueCase || y == trueCase || x == y) {
                use5050();
            } else {
                if (x == 1 || y == 1) {
                    tvCaseA.setText("");
                }
                if (x == 2 || y == 2) {
                    tvCaseB.setText("");
                }
                if (x == 3 || y == 3) {
                    tvCaseC.setText("");
                }
                if (x == 4 || y == 4) {
                    tvCaseD.setText("");
                }
            }
        }
        iv_5050.getDrawable().setLevel(1);
    }

    private void useChangeHelp() {
        if(iv_changeHelp.getDrawable().getLevel()==0){
            QuestionManager.getInstance().getQuestionById(data -> {
                runOnUiThread(()->{
                    QuestionEntities questionEntities= (QuestionEntities) data;
                    tvQuest.setText("Câu"+ count+":");
                    tvDetailQuest.setText(questionEntities.getQuestion());
                    tvCaseA.setText(questionEntities.getCaseA());
                    tvCaseB.setText(questionEntities.getCaseB());
                    tvCaseC.setText(questionEntities.getCaseC());
                    tvCaseD.setText(questionEntities.getCaseD());
                    trueCase=questionEntities.getTrueCase();

                    tvCaseA.setOnClickListener(this);
                    tvCaseB.setOnClickListener(this);
                    tvCaseC.setOnClickListener(this);
                    tvCaseD.setOnClickListener(this);
                });},count);
            iv_changeHelp.getDrawable().setLevel(1);
        }
        else{
            return;
        }
    }

    private void checkAnswer(int i, TextView textView) {
        textView.setBackgroundResource(R.drawable.player_answer_background_selected);
        if(count<16){
           new Handler().postDelayed((new Runnable() {
               @Override
               public void run() {
                   if(i==trueCase){
                       thread.interrupt();
                       textView.setBackgroundResource(R.drawable.player_answer_background_true);
                       Animation myAlpha = AnimationUtils.loadAnimation( M002_Play_Actitity.this,R.anim.anim_anpha);
                       textView.startAnimation(myAlpha);
                       new Handler().postDelayed(new Runnable() {
                           @Override
                           public void run() {
                               count++;
                               initData(count);
                               thread.interrupt();
                               startProgress();
                               textView.setBackgroundResource(R.drawable.ic_question_spicial);
                               switch (count) {
                                   case 2:
                                       tv1.setBackgroundResource(R.drawable.player_answer_background_selected);
                                       break;
                                   case 3:
                                       tv1.setBackgroundResource(0);
                                       tv2.setBackgroundResource(R.drawable.player_answer_background_selected);
                                       break;
                                   case 4:
                                       tv2.setBackgroundResource(0);
                                       tv3.setBackgroundResource(R.drawable.player_answer_background_selected);
                                       break;
                                   case 5:
                                       tv3.setBackgroundResource(0);
                                       tv4.setBackgroundResource(R.drawable.player_answer_background_selected);
                                       break;
                                   case 6:
                                       tv4.setBackgroundResource(0);
                                       tv5.setBackgroundResource(R.drawable.player_answer_background_selected);
                                       break;
                                   case 7:
                                       tv5.setBackgroundResource(0);
                                       tv6.setBackgroundResource(R.drawable.player_answer_background_selected);
                                       break;
                                   case 8:
                                       tv6.setBackgroundResource(0);
                                       tv7.setBackgroundResource(R.drawable.player_answer_background_selected);
                                       break;
                                   case 9:
                                       tv7.setBackgroundResource(0);
                                       tv8.setBackgroundResource(R.drawable.player_answer_background_selected);
                                       break;
                                   case 10:
                                       tv8.setBackgroundResource(0);
                                       tv9.setBackgroundResource(R.drawable.player_answer_background_selected);
                                       break;
                                   case 11:
                                       tv9.setBackgroundResource(0);
                                       tv10.setBackgroundResource(R.drawable.player_answer_background_selected);
                                       break;
                                   case 12:
                                       tv10.setBackgroundResource(0);
                                       tv11.setBackgroundResource(R.drawable.player_answer_background_selected);
                                       break;
                                   case 13:
                                       tv11.setBackgroundResource(0);
                                       tv12.setBackgroundResource(R.drawable.player_answer_background_selected);
                                       break;
                                   case 14:
                                       tv12.setBackgroundResource(0);
                                       tv13.setBackgroundResource(R.drawable.player_answer_background_selected);
                                       break;
                                   case 15:
                                       tv13.setBackgroundResource(0);
                                       tv14.setBackgroundResource(R.drawable.player_answer_background_selected);
                                       break;
                                   default:
                                        break;
                               }
                           }
                       },3000);
                   }else{
                       thread.interrupt();
                       if(trueCase==1){
                           tvCaseA.setBackgroundResource(R.drawable.player_answer_background_true);
                           Animation myAlpha = AnimationUtils.loadAnimation( M002_Play_Actitity.this,R.anim.anim_anpha);
                           tvCaseA.startAnimation(myAlpha);
                       }
                       else if(trueCase==2){
                           tvCaseB.setBackgroundResource(R.drawable.player_answer_background_true);
                           Animation myAlpha = AnimationUtils.loadAnimation( M002_Play_Actitity.this,R.anim.anim_anpha);
                           tvCaseB.startAnimation(myAlpha);
                       }
                       else if(trueCase==3){
                           tvCaseC.setBackgroundResource(R.drawable.player_answer_background_true);
                           Animation myAlpha = AnimationUtils.loadAnimation( M002_Play_Actitity.this,R.anim.anim_anpha);
                           tvCaseC.startAnimation(myAlpha);
                       }
                       else if(trueCase==4){
                           tvCaseD.setBackgroundResource(R.drawable.player_answer_background_true);
                           Animation myAlpha = AnimationUtils.loadAnimation( M002_Play_Actitity.this,R.anim.anim_anpha);
                           tvCaseD.startAnimation(myAlpha);
                       }
                       textView.setBackgroundResource(R.drawable.player_answer_background_wrong);
                       new Handler().postDelayed(new Runnable() {
                           @Override
                           public void run() {
                               M002_Save_Score_Fragment m002_save_score_fragment= new M002_Save_Score_Fragment(score,false);
                               m002_save_score_fragment.show(getSupportFragmentManager(), M002_Save_Score_Fragment.TAG);
                           }
                       },2000);
                   }
               }
           }),2000);
        }
        if(count==16) {
            M002_Save_Score_Fragment m002_save_score_fragment = new M002_Save_Score_Fragment(score,false);
            m002_save_score_fragment.show(getSupportFragmentManager(), M002_Save_Score_Fragment.TAG);
        }
    }
}