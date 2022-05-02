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
public class Zone {
    private int IDSex;
    private String NameZone,Description,Status;


    public String getNameZone() {
        return NameZone;
    }

    public String getDescription() {
        return Description;
    }

    public String getStatus() {
        return Status;
    }

    public void setNameZone(String NameZone) {
        this.NameZone = NameZone;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getIDSex() {
        return IDSex;
    }

    public void setIDSex(int IDSex) {
        this.IDSex = IDSex;
    }
    
}
