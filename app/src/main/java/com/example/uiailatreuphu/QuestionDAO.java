package com.example.uiailatreuphu;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.uiailatreuphu.entities.QuestionEntities;

import java.util.List;

//@Dao
//public interface QuestionDAO {
//    int x = 0;
//    @Query("SELECT * FROM Question1")
//    List<QuestionEntities> getAllQuestion();
//
//    @Query("SELECT * FROM Question1 Where _id = :id")
//    QuestionEntities getQuestionById(int id);
//
//}


@Dao
public interface QuestionDAO {
    int x = 0;
    @Query("SELECT * FROM Question")
    List<QuestionEntities> getAllQuestion();

    @Query("SELECT * FROM (SELECT * FROM Question WHERE level= :level) ORDER BY random() limit 1 ")
    QuestionEntities getQuestionById(int level);
}
