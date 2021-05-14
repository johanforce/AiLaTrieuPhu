package com.example.uiailatreuphu.entities;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.uiailatreuphu.QuestionDAO;


@Database(entities = {QuestionEntities.class}, version = 1)
public abstract class QuestionDB extends RoomDatabase {
    public abstract QuestionDAO getQuestionDAO();
}
