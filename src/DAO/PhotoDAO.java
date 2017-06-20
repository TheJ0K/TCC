/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectionFactory.HibernateUtil;
import Model.Photo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author tiago
 */
public class PhotoDAO {

    private SessionFactory sf = new HibernateUtil().getConnection();
    private Session session;

    public PhotoDAO() {
        session = sf.openSession();
    }

    public boolean addPhoto(Photo p) {
        try {
            Transaction tx = session.beginTransaction();
            session.save(p);
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

    public boolean updatePhoto(Photo p) {
        try {
            Transaction tx = session.beginTransaction();
            session.update(p);
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

    public boolean deletePhoto(Photo p) {
        try {
            Transaction tx = session.beginTransaction();
            session.delete(p);
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
