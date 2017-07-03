/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author tiago
 */
@Entity
@Table
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long iddeveloper;
    private Long age;
    private Long cpf;

    @OneToOne
    @JoinColumn(name = "idpessoa")
    PhysicalPerson physicalPerson;

    @OneToMany(mappedBy = "developer", fetch = FetchType.LAZY,
            targetEntity = IdeaDeveloper.class, cascade = CascadeType.ALL)
    private List<IdeaDeveloper> ideadeve;

    public Developer() {
    }

    public Long getIddeveloper() {
        return iddeveloper;
    }

    public void setIddeveloper(Long iddeveloper) {
        this.iddeveloper = iddeveloper;
    }

    public List<IdeaDeveloper> getIdeadeve() {
        return ideadeve;
    }

    public void setIdeadeve(List<IdeaDeveloper> ideadeve) {
        this.ideadeve = ideadeve;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public PhysicalPerson getPhysicalPerson() {
        return physicalPerson;
    }

    public void setPhysicalPerson(PhysicalPerson physicalPerson) {
        this.physicalPerson = physicalPerson;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
}
