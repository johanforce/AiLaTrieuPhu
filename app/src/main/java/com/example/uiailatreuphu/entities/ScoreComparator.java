package com.example.uiailatreuphu.entities;

import java.util.Comparator;

public class ScoreComparator implements Comparator<Score> {

    @Override
    public int compare(Score o1, Score o2) {
        int score1= o1.getScore();
        int score2=o2.getScore();
        if(score1>score2){
            return -1;
        }else if(score1==score2){
            return 0;
        }else{
            return 0;
        }
    }
}