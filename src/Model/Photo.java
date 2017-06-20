/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author tiago
 */
@Entity
@Table
public class Photo {

    @Id
    @GeneratedValue
    int idPhoto;
    String face, cover;

    /*@OneToOne
    private LegalPerson localPerson;*/
    public Photo() {
    }

    public Photo(String face, String cover) {
        this.face = face;
        this.cover = cover;
    }

    public int getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(int idPhoto) {
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
