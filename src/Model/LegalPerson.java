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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long idlegal;

    @OneToOne(mappedBy = "legalPerson", fetch = FetchType.EAGER)
    @JoinColumn(name = "idcompany")
    private Company company;

    @OneToOne
    @JoinColumn(name = "idstate")
    private State state;

    @OneToOne
    @JoinColumn(name = "idphone")
    private Phone phone;

    @OneToOne
    @JoinColumn(name = "idphoto")
    private Photo photo;

    public LegalPerson() {
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getIdlegal() {
        return idlegal;
    }

    public void setIdlegal(Long idlegal) {
        this.idlegal = idlegal;
    }

}
