/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectionFactory.HibernateUtil;
import Model.LegalPerson;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author tiago
 */
public class LegalPersonDAO {

    private SessionFactory sf = new HibernateUtil().getConnection();
    private Session session;

    public LegalPersonDAO() {
        session = sf.openSession();
    }

    public boolean addLegal(LegalPerson lp) {
        try {
            Transaction tx = session.beginTransaction();
            session.save(lp);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateLegal(LegalPerson lp) {
        try {
            Transaction tx = session.beginTransaction();
            session.update(lp);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteLegal(LegalPerson lp) {
        try {
            Transaction tx = session.beginTransaction();
            session.delete(lp);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*public List<Usuario> getListUsuario() {
        try {
            session = new Fabrica_De_Conexao().getConnection().openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Usuario");
            List<Usuario> list = query.list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("me ferrei");
            return null;
        } finally {
            session.close();
        }
    }*/
    public List<LegalPerson> getList() {
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("FROM LegalPerson");
            q.getFirstResult();

            List<LegalPerson> list = q.list();
            tx.commit();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void closeConnection() {
        try {
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
