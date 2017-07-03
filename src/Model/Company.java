/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author tiago
 */
@Entity
@Table
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long idCompany;
    private String nameCompany;
    private Long cnpj;

    @OneToOne
    @JoinColumn(name = "idlegal")
    private LegalPerson legalPerson;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY,
            targetEntity = IdeaCompany.class, cascade = CascadeType.ALL)
    private List<IdeaCompany> ideacomp;

    public Company() {
    }

    public LegalPerson getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(LegalPerson legalPerson) {
        this.legalPerson = legalPerson;
    }

    public List<IdeaCompany> getIdeaCompany() {
        return ideacomp;
    }

    public void setIdeaCompany(List<IdeaCompany> ideaCompany) {
        this.ideacomp = ideaCompany;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public Long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Long idCompany) {
        this.idCompany = idCompany;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

}
