/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author tiago
 */
@Entity
@Table
public class Phone {

    @Id
    @GeneratedValue
    int idPhone;
    int landLine, mobile;

    @OneToOne
    private LegalPerson legalPerson;

    public Phone() {
    }

    public int getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(int idPhone) {
        this.idPhone = idPhone;
    }

    public int getId() {
        return idPhone;
    }

    public void setId(int idPhone) {
        this.idPhone = idPhone;
    }

    public int getLandLine() {
        return landLine;
    }

    public void setLandLine(int landLine) {
        this.landLine = landLine;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }
}
