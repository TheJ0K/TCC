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
public class IdeaCompany implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id_ideaCompany;
    private String imageCompanyIdea;
    private String titleCompanyIdea;
    private String descriptionCompanyIdea;

    @ManyToOne
    @JoinColumn(name = "company")
    private Company company;

    public IdeaCompany() {
    }

    public IdeaCompany(String imageCompanyIdea, String titleCompanyIdea, String descriptionCompanyIdea) {
        this.imageCompanyIdea = imageCompanyIdea;
        this.titleCompanyIdea = titleCompanyIdea;
        this.descriptionCompanyIdea = descriptionCompanyIdea;
    }

    public IdeaCompany(Long id_ideaCompany, String imageCompanyIdea, String titleCompanyIdea, String descriptionCompanyIdea, Company company) {
        this.id_ideaCompany = id_ideaCompany;
        this.imageCompanyIdea = imageCompanyIdea;
        this.titleCompanyIdea = titleCompanyIdea;
        this.descriptionCompanyIdea = descriptionCompanyIdea;
        this.company = company;
    }

    public Long getId_ideaCompany() {
        return id_ideaCompany;
    }

    public void setId_ideaCompany(Long id_ideaCompany) {
        this.id_ideaCompany = id_ideaCompany;
    }

    public String getImageCompanyIdea() {
        return imageCompanyIdea;
    }

    public void setImageCompanyIdea(String imageCompanyIdea) {
        this.imageCompanyIdea = imageCompanyIdea;
    }

    public String getTitleCompanyIdea() {
        return titleCompanyIdea;
    }

    public void setTitleCompanyIdea(String titleCompanyIdea) {
        this.titleCompanyIdea = titleCompanyIdea;
    }

    public String getDescriptionCompanyIdea() {
        return descriptionCompanyIdea;
    }

    public void setDescriptionCompanyIdea(String descriptionCompanyIdea) {
        this.descriptionCompanyIdea = descriptionCompanyIdea;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
