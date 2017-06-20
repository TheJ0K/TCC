/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectionFactory.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author tiago
 */
public class PersonDAO {

    private SessionFactory sf = new HibernateUtil().getConnection();
    private Session session;

    public PersonDAO() {
        session = sf.openSession();
    }
}
