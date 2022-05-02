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
public class TypeRoom {
    private int ID,Cost;
    private String TypeOfRoom;
    private String Description;

    public int getID() {
        return ID;
    }

    public String getTypeOfRoom() {
        return TypeOfRoom;
    }

    public String getDescription() {
        return Description;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTypeOfRoom(String TypeOfRoom) {
        this.TypeOfRoom = TypeOfRoom;
    }


    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int Cost) {
        this.Cost = Cost;
    }
    
}
