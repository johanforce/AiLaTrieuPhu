package com.example.uiailatreuphu;

import android.app.Application;

import androidx.room.Room;

import com.example.uiailatreuphu.entities.QuestionDB;


public class App extends Application {
    private  static App instance;
    private QuestionDB questionDB;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        initDB();
    }

    private void initDB() {
        questionDB= Room.databaseBuilder(this,QuestionDB.class,"Question.db")
                .createFromAsset("databases/Question.db").build();
    }

    public  static App getInstance(){
        return  instance;
    }

    public QuestionDB getQuestionDB() {
        return questionDB;
    }
}
