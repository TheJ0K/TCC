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

    @Override
    @SequenceGenerator(name = "id_legalperson")
    public int getIdPessoa() {
        return super.getIdPessoa();
    }

    @OneToOne(mappedBy = "legalPerson", fetch = FetchType.EAGER)
    @JoinColumn(name = "idphone")
    @Override
    public Phone getPhone() {
        return phone;
    }
    

    @OneToOne(mappedBy = "legalPerson", fetch = FetchType.EAGER)
    @JoinColumn(name = "idphoto")
    @Override
    public Photo getPhoto() {
        return super.getPhoto();
    }
    
    private Company company;

    @OneToOne(mappedBy = "legalPerson", fetch = FetchType.EAGER)
    @JoinColumn(name = "idcompany")
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LegalPerson() {
    }

}
