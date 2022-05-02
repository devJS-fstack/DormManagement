/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author VanTinh
 */
public class Feedback {
    private int idFeedback;
    private String idStudent;
    private int evaP,
            evaS,
            evaA;
    private String content;
    private Date dateCreate;

    public Feedback(int idFeedback, String idStudent, int evaP, int evaS, int evaA, String content,Date dateCreate) {
        this.idFeedback = idFeedback;
        this.idStudent = idStudent;
        this.evaP = evaP;
        this.evaS = evaS;
        this.evaA = evaA;
        this.content = content;
        this.dateCreate=dateCreate;
    }

    public Feedback() {
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public int getIdFeedback() {
        return idFeedback;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public int getEvaP() {
        return evaP;
    }

    public int getEvaS() {
        return evaS;
    }

    public int getEvaA() {
        return evaA;
    }

    public String getContent() {
        return content;
    }

    public void setIdFeedback(int idFeedback) {
        this.idFeedback = idFeedback;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public void setEvaP(int evaP) {
        this.evaP = evaP;
    }

    public void setEvaS(int evaS) {
        this.evaS = evaS;
    }

    public void setEvaA(int evaA) {
        this.evaA = evaA;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
