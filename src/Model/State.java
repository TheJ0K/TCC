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
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    int idState;
    String nameState;

    @OneToOne(mappedBy = "state", fetch = FetchType.EAGER)
    @JoinColumn(name = "idphysical")
    private PhysicalPerson physical;

    @OneToOne(mappedBy = "state", fetch = FetchType.EAGER)
    @JoinColumn(name = "idlegal")
    private LegalPerson legalPerson;

    public LegalPerson getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(LegalPerson legalPerson) {
        this.legalPerson = legalPerson;
    }

    @OneToOne
    @JoinColumn(name = "idcity")
    private City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }

    /*public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }*/
    public String getNameState() {
        return nameState;
    }

    public void setNameState(String nameState) {
        this.nameState = nameState;
    }
}
