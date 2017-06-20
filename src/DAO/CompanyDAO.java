/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ConnectionFactory.HibernateUtil;
import Model.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author tiago
 */
public class CompanyDAO {

    private SessionFactory sf = new HibernateUtil().getConnection();
    private Session session;

    public CompanyDAO() {
        session = sf.openSession();
    }

    public boolean addCompany(Company c) {
        try {
            Transaction tx = session.beginTransaction();
            session.save(c);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
        }
    }

    public boolean updateCompany(Company c) {
        try {
            Transaction tx = session.beginTransaction();
            session.update(c);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
        }
    }

    public boolean deleteCompany(Company c) {
        try {
            Transaction tx = session.beginTransaction();
            session.delete(c);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
        }
    }
}
