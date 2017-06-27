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
public class PhysicalPerson extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long idphysical;

    @OneToOne(mappedBy = "physicalPerson", fetch = FetchType.EAGER)
    @JoinColumn(name = "iddeveloper")
    private Developer developer;

    @OneToOne
    @JoinColumn(name = "idstate")
    private State state;

    @OneToOne
    @JoinColumn(name = "idphone")
    private Phone phone;

    @OneToOne
    @JoinColumn(name = "idphoto")
    private Photo photo;

    public Long getIdphysical() {
        return idphysical;
    }

    public void setIdphysical(Long idphysical) {
        this.idphysical = idphysical;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }
}
