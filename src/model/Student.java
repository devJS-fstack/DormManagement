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
public class Student {
    private String hoTen,mssv,gioiTinh,sdt,email,address,quocTich,tonGiao,lop,cmnd,danToc,IDUs,Nganh;
    Date dateOfBirth;

    public Student(String hoTen, String mssv, String gioiTinh, String sdt, String email, String address, String quocTich, String tonGiao, String lop, String cmnd, String danToc, String IDUs, Date dateOfBirth,String Nganh) {
        this.hoTen = hoTen;
        this.mssv = mssv;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.email = email;
        this.address = address;
        this.quocTich = quocTich;
        this.tonGiao = tonGiao;
        this.lop = lop;
        this.cmnd = cmnd;
        this.danToc = danToc;
        this.IDUs=IDUs;
        this.dateOfBirth = dateOfBirth;
        this.Nganh=Nganh;
    }

    public Student() {
    }

    public void setNganh(String Nganh) {
        this.Nganh = Nganh;
    }

    public String getNganh() {
        return Nganh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getMssv() {
        return mssv;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public String getTonGiao() {
        return tonGiao;
    }

    public String getLop() {
        return lop;
    }

    public String getCmnd() {
        return cmnd;
    }

    public String getDanToc() {
        return danToc;
    }


    public String getIDUs() {
        return IDUs;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public void setTonGiao(String tonGiao) {
        this.tonGiao = tonGiao;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public void setIDUs(String IDUs) {
        this.IDUs = IDUs;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
}
