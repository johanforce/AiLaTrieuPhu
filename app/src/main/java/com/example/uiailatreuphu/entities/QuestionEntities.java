package com.example.uiailatreuphu.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

//@Entity(tableName = "Question1", primaryKeys = {"_id"})
//public class QuestionEntities {
//    @NonNull
//    @ColumnInfo(name = "_id")
//    private int id;
//
//    @ColumnInfo(name = "Question")
//    private String question;
//
//    @ColumnInfo(name = "CaseA")
//    private String caseA;
//
//    @ColumnInfo(name = "CaseB")
//    private String caseB;
//
//    @ColumnInfo(name = "CaseC")
//    private String caseC;
//
//    @ColumnInfo(name = "CaseD")
//    private String caseD;
//
//
//    @ColumnInfo(name = "TrueCase")
//    private int trueCase;
//
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getQuestion() {
//        return question;
//    }
//
//    public void setQuestion(String question) {
//        this.question = question;
//    }
//
//    public String getCaseA() {
//        return caseA;
//    }
//
//    public void setCaseA(String caseA) {
//        this.caseA = caseA;
//    }
//
//    public String getCaseB() {
//        return caseB;
//    }
//
//    public void setCaseB(String caseB) {
//        this.caseB = caseB;
//    }
//
//    public String getCaseC() {
//        return caseC;
//    }
//
//    public void setCaseC(String caseC) {
//        this.caseC = caseC;
//    }
//
//    public String getCaseD() {
//        return caseD;
//    }
//
//    public void setCaseD(String caseD) {
//        this.caseD = caseD;
//    }
//
//    public Integer getTrueCase() {
//        return trueCase;
//    }
//
//    public void setTrueCase(Integer trueCase) {
//        this.trueCase = trueCase;
//    }
//}

@Entity(tableName = "Question", primaryKeys = {"_id"})
public class QuestionEntities {
    @ColumnInfo(name = "question")
    private String question;

    @NonNull
    @ColumnInfo(name = "_id")
    private int id;

    @NonNull
    @ColumnInfo(name = "level")
    private int level;

    @ColumnInfo(name = "caseA")
    private String caseA;
    @ColumnInfo(name = "caseB")
    private String caseB;
    @ColumnInfo(name = "caseC")
    private String caseC;
    @ColumnInfo(name = "caseD")
    private String caseD;

    @NonNull
    @ColumnInfo(name = "TrueCase")
    private int trueCase;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCaseA() {
        return caseA;
    }

    public void setCaseA(String caseA) {
        this.caseA = caseA;
    }

    public String getCaseB() {
        return caseB;
    }

    public void setCaseB(String caseB) {
        this.caseB = caseB;
    }

    public String getCaseC() {
        return caseC;
    }

    public void setCaseC(String caseC) {
        this.caseC = caseC;
    }

    public String getCaseD() {
        return caseD;
    }

    public void setCaseD(String caseD) {
        this.caseD = caseD;
    }

    public Integer getTrueCase() {
        return trueCase;
    }

    public void setTrueCase(int trueCase) {
        this.trueCase = trueCase;
    }
}
//
