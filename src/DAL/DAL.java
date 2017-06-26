package DAL;

import ConnectionFactory.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author User
 */
public class DAL<G> {

    private SessionFactory sf = new HibernateUtil().getConnection();
    private Session session;

    private Transaction tx;

    private void init() {
        session = sf.openSession();
        tx = session.beginTransaction();
    }

    //Esse método recebe um parametro genérico que será adicionado.
    public boolean add(G c) {
        init();
        try {
            session.save(c);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        /*finally {
            closeConnection();
        }*/
    }

    //Esse método recebe um parametro genérico que será editado.
    public boolean update(G c) {
        try {
            init();
            session.update(c);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            closeConnection();
        }
    }

    //Esse método recebe um parametro genérico que será deletado.
    public boolean delete(G c) {
        try {
            init();
            session.delete(c);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            closeConnection();
        }
    }

    //Esse é um método genérico, que faz um select e puxa uma LIST com as informações
    //da tabela indicada, a tabela em questão é indicada pelo seu nome passado por parametro (String c)
    public <G> List<G> getList(String c) {
        try {
            init();
            Query q = session.createQuery("FROM " + c);
            q.getFirstResult();
            List<G> list = q.list();
            tx.commit();
            return list;
        } catch (Exception e) {
            return null;
        } finally {
            closeConnection();
        }
    }

    private void closeConnection() {
        if (session.isOpen()) {
            session.clear();
            session.close();
        }
    }

}
