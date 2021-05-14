package com.example.uiailatreuphu;

//public class QuestionManager  {
//    private static QuestionManager instance;
//    private  QuestionManager(){
//
//    }
//
//    public  static QuestionManager getInstance(){
//        if(instance==null){
//            instance= new QuestionManager();
//        }
//        return instance;
//    }
//
//    public  interface  OnHSCallBack{
//        void callBack(Object data);
//    }
//
//    public void getQuestionById(final OnHSCallBack cb, int id){
//        new Thread(){
//            @Override
//            public void run() {
//                try {
//                    cb.callBack(App.getInstance().getQuestionDB().getQuestionDAO().getQuestionById(id));
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        }.start();
//    }
//}

public class QuestionManager  {
    private static QuestionManager instance;
    private  QuestionManager(){

    }

    public  static QuestionManager getInstance(){
        if(instance==null){
            instance= new QuestionManager();
        }
        return instance;
    }

    public  interface  OnHSCallBack{
        void callBack(Object data);
    }

    public void getQuestionById(final OnHSCallBack cb, int level){
        new Thread(){
            @Override
            public void run() {
                try {
                    cb.callBack(App.getInstance().getQuestionDB().getQuestionDAO().getQuestionById(level));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();
    }
}

