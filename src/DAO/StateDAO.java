/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectionFactory.HibernateUtil;
import Model.State;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author tiago
 */
public class StateDAO {

    private SessionFactory sf = new HibernateUtil().getConnection();
    private Session session;

    public StateDAO() {
        session = sf.openSession();
    }

    public boolean addState(State s) {
        try {
            Transaction tx = session.beginTransaction();
            session.save(s);
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

    public boolean updateState(State s) {
        try {
            Transaction tx = session.beginTransaction();
            session.update(s);
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

    public boolean deleteState(State s) {
        try {
            Transaction tx = session.beginTransaction();
            session.delete(s);
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
