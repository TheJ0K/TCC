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
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long idPhoto;
    private String face, cover;

    @OneToOne(mappedBy = "photo", fetch = FetchType.EAGER)
    @JoinColumn(name = "idphysical")
    private PhysicalPerson physical;

    @OneToOne(mappedBy = "photo", fetch = FetchType.EAGER)
    @JoinColumn(name = "idlegal")
    private LegalPerson legalPerson;

    public LegalPerson getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(LegalPerson legalPerson) {
        this.legalPerson = legalPerson;
    }

    public Photo() {
    }

    public PhysicalPerson getPhysical() {
        return physical;
    }

    public void setPhysical(PhysicalPerson physical) {
        this.physical = physical;
    }

    public Long getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(Long idPhoto) {
        this.idPhoto = idPhoto;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
