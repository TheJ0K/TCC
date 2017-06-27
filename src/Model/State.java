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
@Table(name = "states")
public class State implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int idState;
    private String nameState;

    @OneToOne(mappedBy = "state", fetch = FetchType.EAGER)
    @JoinColumn(name = "idphysical")
    private PhysicalPerson physical;

    @OneToOne(mappedBy = "state", fetch = FetchType.EAGER)
    @JoinColumn(name = "idlegal")
    private LegalPerson legalPerson;

    @OneToOne
    @JoinColumn(name = "idcity")
    private City city;

    public State() {
    }

    public PhysicalPerson getPhysical() {
        return physical;
    }

    public void setPhysical(PhysicalPerson physical) {
        this.physical = physical;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public LegalPerson getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(LegalPerson legalPerson) {
        this.legalPerson = legalPerson;
    }

    public int getIdState() {
        return idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }

    public String getNameState() {
        return nameState;
    }

    public void setNameState(String nameState) {
        this.nameState = nameState;
    }
}
