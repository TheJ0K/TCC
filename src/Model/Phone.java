/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.*;

/**
 *
 * @author tiago
 */
@Entity
@Table
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long idPhone;
    private Long landLine, mobile;
    
    @OneToOne(mappedBy = "phone", fetch = FetchType.EAGER)
    @JoinColumn(name = "idlegal")
    private LegalPerson legalPerson;

    @OneToOne(mappedBy = "phone", fetch = FetchType.EAGER)
    @JoinColumn(name = "idphysical")
    private PhysicalPerson physicalPerson;

    public Phone() {
    }

    public Long getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(Long idPhone) {
        this.idPhone = idPhone;
    }

    public Long getLandLine() {
        return landLine;
    }

    public void setLandLine(Long landLine) {
        this.landLine = landLine;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public PhysicalPerson getPhisycal() {
        return physicalPerson;
    }

    public void setPhisycal(PhysicalPerson physicalPerson) {
        this.physicalPerson = physicalPerson;
    }

    public LegalPerson getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(LegalPerson legalPerson) {
        this.legalPerson = legalPerson;
    }

}
