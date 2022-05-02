
package model;

import java.io.Serializable;


public class User implements  Serializable{
    private String IDUs,Pass;
    private int IDRole;
    private String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setIDRole(int IDRole) {
        this.IDRole = IDRole;
    }

    public int getIDRole() {
        return IDRole;
    }

    public String getIDUs() {
        return IDUs;
    }
    public void setIDUs(String IDUs) {
        this.IDUs = IDUs;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public String getPass() {
        return Pass;
    }

    
}
