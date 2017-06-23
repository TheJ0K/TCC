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
    @GeneratedValue
    int idState;
    String nameState;

    @OneToOne
    @JoinColumn(name="idCity")
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
