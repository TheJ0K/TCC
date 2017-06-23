/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.persistence.*;



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
    @JoinColumn(name="idpessoa")
    private LegalPerson legalPerson;
    @OneToMany(mappedBy = "phone")
    private List<LegalPerson> legalPersons;

    public LegalPerson getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(LegalPerson legalPerson) {
        this.legalPerson = legalPerson;
    }
    

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
