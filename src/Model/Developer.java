/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author tiago
 */
@Entity
@Table
public class Developer {

    @Id
    @GeneratedValue
    private int id;
    private Date age;
    private int cpf;

    @OneToOne
    PhysicalPerson physicalPerson;

    public Developer() {
    }

    public Developer(int id, Date age, int cpf, PhysicalPerson physicalPerson) {
        this.id = id;
        this.age = age;
        this.cpf = cpf;
        this.physicalPerson = physicalPerson;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
}
