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
public class Request {
    private String noiDung,Status,IDUs;
    private Date DateRequest;
     private int IDRequest;

    public int getIDRequest() {
        return IDRequest;
    }

    public String getNameRequest() {
        return noiDung;
    }

    public String getStatus() {
        return Status;
    }

    public String getIDUs() {
        return IDUs;
    }

    public Date getDateRequest() {
        return DateRequest;
    }

    public Request(int IDRequest, String NameRequest, String Status, String IDUs, Date DateRequest) {
        this.IDRequest = IDRequest;
        this.noiDung = NameRequest;
        this.Status = Status;
        this.IDUs = IDUs;
        this.DateRequest = DateRequest;
    }

    public Request() {
    }

    public void setIDRequest(int IDRequest) {
        this.IDRequest = IDRequest;
    }

    public void setNameRequest(String NameRequest) {
        this.noiDung = NameRequest;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setIDUs(String IDUs) {
        this.IDUs = IDUs;
    }

    public void setDateRequest(Date DateRequest) {
        this.DateRequest = DateRequest;
    }
}
