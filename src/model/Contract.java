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
public class Contract {
    private int Payment;
    private int IDContract,
                amountOfMonth;
    private String IDStudent,IDStaff,IDRoom;
    Date StartDay,FinishDay;
    public Contract(int IDContract, String IDRoom, int Payment, String IDStudent, String IDStaff, Date StartDay, Date FinishDay,int amountOfMonth) {
        this.IDContract = IDContract;
        this.IDRoom = IDRoom;
        this.Payment = Payment;
        this.IDStudent = IDStudent;
        this.IDStaff = IDStaff;
        this.StartDay = StartDay;
        this.FinishDay = FinishDay;
        this.amountOfMonth=amountOfMonth;
    }
    public Contract() {
    }

    public int getAmountOfMonth() {
        return amountOfMonth;
    }

    public void setAmountOfMonth(int amountOfMonth) {
        this.amountOfMonth = amountOfMonth;
    }

    public int getIDContract() {
        return IDContract;
    }

    public String getIDRoom() {
        return IDRoom;
    }

    public int getPayment() {
        return Payment;
    }

    public String getIDStudent() {
        return IDStudent;
    }

    public String getIDStaff() {
        return IDStaff;
    }

    public Date getStartDay() {
        return StartDay;
    }

    public Date getFinishDay() {
        return FinishDay;
    }

    public void setIDContract(int IDContract) {
        this.IDContract = IDContract;
    }

    public void setIDRoom(String IDRoom) {
        this.IDRoom = IDRoom;
    }

    public void setPayment(int Payment) {
        this.Payment = Payment;
    }

    public void setIDStudent(String IDStudent) {
        this.IDStudent = IDStudent;
    }

    public void setIDStaff(String IDStaff) {
        this.IDStaff = IDStaff;
    }

    public void setStartDay(Date StartDay) {
        this.StartDay = StartDay;
    }

    public void setFinishDay(Date FinishDay) {
        this.FinishDay = FinishDay;
    }
    
}
