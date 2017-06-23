/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author tiago
 */
@MappedSuperclass
public class Person implements Serializable {

    @Id
    @SequenceGenerator(name = "id_pessoa")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idPessoa;
    private String name, lastName, email, password, description;

    public Photo photo;
    public Phone phone;

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

    public Person() {
    }

    public Person(String name, String lastName, String email, String password, String description) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.description = description;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
