/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Diogo Fistarol
 */
@Entity
@Table
public class IdeaDeveloper implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id_ideaDeveloper;
    private String imageDeveloperIdea;
    private String titleDeveloperIdea;
    private String descriptionDeveloperIdea;

    @ManyToOne
    @JoinColumn(name = "developer")
    private Developer developer;

    public IdeaDeveloper() {
    }

    public IdeaDeveloper(Long id_ideaDeveloper, String imageDeveloperIdea, String titleDeveloperIdea, String descriptionDeveloperIdea, Developer developer) {
        this.id_ideaDeveloper = id_ideaDeveloper;
        this.imageDeveloperIdea = imageDeveloperIdea;
        this.titleDeveloperIdea = titleDeveloperIdea;
        this.descriptionDeveloperIdea = descriptionDeveloperIdea;
        this.developer = developer;
    }

    public IdeaDeveloper(String imageDeveloperIdea, String titleDeveloperIdea, String descriptionDeveloperIdea) {
        this.imageDeveloperIdea = imageDeveloperIdea;
        this.titleDeveloperIdea = titleDeveloperIdea;
        this.descriptionDeveloperIdea = descriptionDeveloperIdea;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Long getId_ideaDeveloper() {
        return id_ideaDeveloper;
    }

    public void setId_ideaDeveloper(Long id_ideaDeveloper) {
        this.id_ideaDeveloper = id_ideaDeveloper;
    }

    public String getImageDeveloperIdea() {
        return imageDeveloperIdea;
    }

    public void setImageDeveloperIdea(String imageDeveloperIdea) {
        this.imageDeveloperIdea = imageDeveloperIdea;
    }

    public String getTitleDeveloperIdea() {
        return titleDeveloperIdea;
    }

    public void setTitleDeveloperIdea(String titleDeveloperIdea) {
        this.titleDeveloperIdea = titleDeveloperIdea;
    }

    public String getDescriptionDeveloperIdea() {
        return descriptionDeveloperIdea;
    }

    public void setDescriptionDeveloperIdea(String descriptionDeveloperIdea) {
        this.descriptionDeveloperIdea = descriptionDeveloperIdea;
    }

}
