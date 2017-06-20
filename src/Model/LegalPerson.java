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
public class LegalPerson extends Person {

    @OneToOne(mappedBy = "legalPerson", fetch = FetchType.EAGER)
    @JoinColumn(name = "idPhone")
    private Phone phone;

    @OneToOne(mappedBy = "legalPerson", fetch = FetchType.EAGER)
    @JoinColumn(name = "idcompany")
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    /*@OneToOne(mappedBy = "legalPerson", fetch = FetchType.EAGER)
    @JoinColumn(name = "legalPerson")
    private Photo photo;

    @OneToOne(mappedBy = "legalPerson", fetch = FetchType.EAGER)
    @JoinColumn(name = "legalPerson")
    private State state;*/
    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public LegalPerson() {
    }

}
