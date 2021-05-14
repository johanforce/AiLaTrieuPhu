  package com.example.uiailatreuphu;

  import android.app.AlertDialog;
  import android.content.DialogInterface;
  import android.os.Bundle;
  import android.view.View;
  import android.widget.TextView;

  import androidx.appcompat.app.AppCompatActivity;

  import com.example.uiailatreuphu.entities.QuestionEntities;


  public class MainActivity extends AppCompatActivity {
     private TextView tvNumberQuestion, tvContentQuestion, tvCaseA, tvCaseB, tvCaseC, tvCaseD, tvResult, tvScore;
     private QuestionManager questionManager;
     private int result=0;
     private int trueCase;
     private int id=1;
     private int numberQuestion=1;
     private int level=1;
     private int count=0;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         initViews();
     }

     private void initViews() {
         tvNumberQuestion=findViewById(R.id.tv_numberQuestion);
         tvContentQuestion=findViewById(R.id.tv_contentQuestion);
         tvCaseA=findViewById(R.id.tv_caseA);
         tvCaseB=findViewById(R.id.tv_caseB);
         tvCaseC=findViewById(R.id.tv_caseC);
         tvCaseD=findViewById(R.id.tv_caseD);
         tvResult=findViewById(R.id.tv_result);
         tvScore=findViewById(R.id.tv_score);
         initData();
     }

     private void initData() {
         QuestionManager.getInstance().getQuestionById(data -> {
             runOnUiThread(()->{
                 QuestionEntities questionEntities= (QuestionEntities) data;
                 tvNumberQuestion.setText("Câu số "+ numberQuestion+":");
                 tvContentQuestion.setText(questionEntities.getQuestion());
                 tvCaseA.setText(questionEntities.getCaseA().toString());
                 tvCaseB.setText(questionEntities.getCaseB());
                 tvCaseC.setText(questionEntities.getCaseC());
                 tvCaseD.setText(questionEntities.getCaseD());
                 trueCase= questionEntities.getTrueCase();
                 tvScore.setText("Điểm: "+ count);
             });},level);
         tvCaseA.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 result=1;
                 if(result==trueCase){
                     tvResult.setText("Đúng con mẹ mày rồi. Giỏi thế!");
                     count++;
                 }else{
                     tvResult.setText("Ngu! Dễ thế mà sai!");
                     loseGame();
                 }
                 result=0;
                 level++;
                 numberQuestion++;
                 tvScore.setText("Điểm: "+ count);
                 initData();
             }
         });


         tvCaseB.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 result=2;
                 if(result==trueCase){
                     tvResult.setText("Đúng con mẹ mày rồi. Giỏi thế!");
                     count++;
                 }else{
                     tvResult.setText("Ngu! Dễ thế mà sai!");
                     loseGame();
                 }
                 result=0;
                 level++;
                 numberQuestion++;
                 tvScore.setText("Điểm: "+ count);
                 initData();
             }
         });
         tvCaseC.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 result=3;
                 if(result==trueCase){
                     tvResult.setText("Đúng con mẹ mày rồi. Giỏi thế!");
                     count++;
                 }else{
                     tvResult.setText("Ngu! Dễ thế mà sai!");
                     loseGame();
                 }
                 result=0;
                 level++;
                 numberQuestion++;
                 tvScore.setText("Điểm: "+ count);
                 initData();
             }
         });
         tvCaseD.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 result=4;
                 if(result==trueCase){
                     tvResult.setText("Đúng con mẹ mày rồi. Giỏi thế!");
                     count++;
                 }else{
                     tvResult.setText("Ngu! Dễ thế mà sai!");
                     loseGame();
                 }
                 result=0;
                 level++;
                 numberQuestion++;
                 tvScore.setText("Điểm: "+ count);
                 initData();
             }
         });
         if(level==4){
             new AlertDialog.Builder(this)
                     .setTitle("Chúc mừng")
                     .setMessage("Bạn đã dành chiến thắng!!!")

                     // Specifying a listener allows you to take an action before dismissing the dialog.
                     // The dialog is automatically dismissed when a dialog button is clicked.
                     .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                         public void onClick(DialogInterface dialog, int which) {
                             // Continue with delete operation
                         }
                     })

                     // A null listener allows the button to dismiss the dialog and take no further action.
                     .setNegativeButton(android.R.string.no, null)
                     .setIcon(android.R.drawable.ic_dialog_alert)
                     .show();
         }
     }

     public void loseGame() {
         new AlertDialog.Builder(this)
                 .setTitle("Thua cuộc")
                 .setMessage("Bạn đã trả lời sai! Có muốn chơi lại không? ")

                 // Specifying a listener allows you to take an action before dismissing the dialog.
                 // The dialog is automatically dismissed when a dialog button is clicked.
                 .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         // Continue with delete operation
                     }
                 })

                 // A null listener allows the button to dismiss the dialog and take no further action.
                 .setNegativeButton(android.R.string.no, null)
                 .setIcon(android.R.drawable.ic_dialog_alert)
                 .show();
     }

 }