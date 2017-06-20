/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectionFactory.HibernateUtil;
import Model.PhysicalPerson;
import Model.State;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author tiago
 */
public class PhysicalPersonDAO {

    private SessionFactory sf = new HibernateUtil().getConnection();
    private Session session;

    public PhysicalPersonDAO() {
        session = sf.openSession();
    }

    public boolean addPhysicalPerson(PhysicalPerson pp) {
        try {
            Transaction tx = session.beginTransaction();
            session.save(pp);
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

    public boolean updatePhysicalPerson(PhysicalPerson pp) {
        try {
            Transaction tx = session.beginTransaction();
            session.update(pp);
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

    public boolean deletePhysicalPerson(PhysicalPerson pp) {
        try {
            Transaction tx = session.beginTransaction();
            session.delete(pp);
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
