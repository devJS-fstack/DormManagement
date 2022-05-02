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
public class Bill {
    private String IDStaff,Status,IDStudent,NoiDung,TypeBill,Semester;
    private Date DateCreate;
    private int Payment,IDBill;
    public int getIDBill() {
        return IDBill;
    }

    public String getIDStaff() {
        return IDStaff;
    }

    public String getStatus() {
        return Status;
    }

    public String getIDStudent() {
        return IDStudent;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public String getTypeBill() {
        return TypeBill;
    }

    public Date getDateCreate() {
        return DateCreate;
    }

    public void setIDBill(int IDBill) {
        this.IDBill = IDBill;
    }

    public void setIDStaff(String IDStaff) {
        this.IDStaff = IDStaff;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setIDStudent(String IDStudent) {
        this.IDStudent = IDStudent;
    }

    public void setNoiDung(String NoiDung) {
        this.NoiDung = NoiDung;
    }

    public void setTypeBill(String TypeBill) {
        this.TypeBill = TypeBill;
    }

    public void setDateCreate(Date DateCreate) {
        this.DateCreate = DateCreate;
    }

    public void setPayment(int Payment) {
        this.Payment = Payment;
    }

    public int getPayment() {
        return Payment;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String Semester) {
        this.Semester = Semester;
    }

    public Bill(int IDBill, String IDStaff, String Status, String IDStudent, String NoiDung, String TypeBill, Date DateCreate,int Payment,String Semester) {
        this.IDBill = IDBill;
        this.IDStaff = IDStaff;
        this.Status = Status;
        this.IDStudent = IDStudent;
        this.NoiDung = NoiDung;
        this.TypeBill = TypeBill;
        this.DateCreate = DateCreate;
        this.Payment=Payment;
        this.Semester=Semester;
    }
    public Bill(){
        
    }
}
