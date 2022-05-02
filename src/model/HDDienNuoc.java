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
public class HDDienNuoc {
    private String IDRoom,Status;
    private Date closingDate;
    private int headIndexE,lastIndexE,useE,month,year,IDHD;
    private int costE;
    private int totalPayment;
    private String idStaff;

    public HDDienNuoc(int IDHD, String IDRoom, String Status, Date closingDate, int headIndexE, int lastIndexE, int useE, int costE, int totalPayment,int month,int year,String idStaff) {
        this.IDHD = IDHD;
        this.IDRoom = IDRoom;
        this.Status = Status;
        this.closingDate = closingDate;
        this.headIndexE = headIndexE;
        this.lastIndexE = lastIndexE;
        this.useE = useE;
        this.costE = costE;
        this.totalPayment = totalPayment;
        this.month=month;
        this.year=year;
        this.idStaff=idStaff;
    }

    public String getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }
    
     public HDDienNuoc(){
         
     }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getMonth() {
        return month;
    }
    public int getIDHD() {
        return IDHD;
    }

    public String getIDRoom() {
        return IDRoom;
    }

    public String getStatus() {
        return Status;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public int getHeadIndexE() {
        return headIndexE;
    }

    public int getLastIndexE() {
        return lastIndexE;
    }

    public int getUseE() {
        return useE;
    }


    public int getCostE() {
        return costE;
    }


    public int getTotalPayment() {
        return totalPayment;
    }

    public void setIDHD(int IDHD) {
        this.IDHD = IDHD;
    }

    public void setIDRoom(String IDRoom) {
        this.IDRoom = IDRoom;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public void setHeadIndexE(int headIndexE) {
        this.headIndexE = headIndexE;
    }

    public void setLastIndexE(int lastIndexE) {
        this.lastIndexE = lastIndexE;
    }

    public void setUseE(int useE) {
        this.useE = useE;
    }

 

    public void setCostE(int costE) {
        this.costE = costE;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }
    
}
