/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author tiago
 */
@Entity
@Table
public class Company implements Serializable {

    @Id
    @GeneratedValue
    private int idCompany;
    private String nameCompany;
    private int cnpj;

    @OneToOne
    @JoinColumn(name = "idpessoa")
    private LegalPerson legalPerson;

    public Company() {
    }

    public Company(int idCompany, String nameCompany, int cnpj, LegalPerson legalPerson) {
        this.idCompany = idCompany;
        this.nameCompany = nameCompany;
        this.cnpj = cnpj;
        this.legalPerson = legalPerson;
    }

    public LegalPerson getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(LegalPerson legalPerson) {
        this.legalPerson = legalPerson;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }
}
