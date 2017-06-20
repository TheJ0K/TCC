/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectionFactory.HibernateUtil;
import Model.Developer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author tiago
 */
public class DeveloperDAO {

    private SessionFactory sf = new HibernateUtil().getConnection();
    private Session session;

    public DeveloperDAO() {
        session = sf.openSession();
    }

    public boolean addDeveloper(Developer u) {
        try {
            Transaction tx = session.beginTransaction();
            session.save(u);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (session.isOpen()) {
                session.close();
            } else {
            }
        }
    }

    public boolean updateDeveloper(Developer u) {
        try {
            Transaction tx = session.beginTransaction();
            session.update(u);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (session.isOpen()) {
                session.close();
            } else {
            }
        }
    }

    public boolean deleteDeveloper(Developer u) {
        try {
            Transaction tx = session.beginTransaction();
            session.delete(u);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (session.isOpen()) {
                session.close();
            } else {
            }
        }
    }
}
