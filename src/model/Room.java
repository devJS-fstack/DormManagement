/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author VanTinh
 */
public class Room {
    private int Max,AmountOfNow;
    public String status,NameRoom,NameZone;
    private String IDRoom;
    int IDType;

    public String getIDRoom() {
        return IDRoom;
    }

    public void setAmountOfNow(int AmountOfNow) {
        this.AmountOfNow = AmountOfNow;
    }

    public int getAmountOfNow() {
        return AmountOfNow;
    }

    public int getMax() {
        return Max;
    }


    public String getStatus() {
        return status;
    }


    public int getIDType() {
        return IDType;
    }

    public void setIDRoom(String IDRoom) {
        this.IDRoom = IDRoom;
    }

    public void setMax(int Max) {
        this.Max = Max;
    }



    public void setStatus(String status) {
        this.status = status;
    }

    public void setIDType(int IDType) {
        this.IDType = IDType;
    }

    public String getIDZone() {
        return NameZone;
    }

    public void setIDZone(String NameZone) {
        this.NameZone = NameZone;
    }

    public String getNameRoom() {
        return NameRoom;
    }

    public void setNameRoom(String NameRoom) {
        this.NameRoom = NameRoom;
    }
    
}
