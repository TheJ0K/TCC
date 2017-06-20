/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectionFactory.HibernateUtil;
import Model.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author tiago
 */
public class CityDAO {

    private SessionFactory sf = new HibernateUtil().getConnection();
    private Session session;

    public CityDAO() {
        session = sf.openSession();
    }

    public boolean addCity(City c) {
        try {
            Transaction tx = session.beginTransaction();
            session.save(c);
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

    public boolean updateCity(City c) {
        try {
            Transaction tx = session.beginTransaction();
            session.update(c);
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

    public boolean deleteCity(City c) {
        try {
            Transaction tx = session.beginTransaction();
            session.delete(c);
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
