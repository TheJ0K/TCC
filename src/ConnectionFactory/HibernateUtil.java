package ConnectionFactory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author tiago
 */
public class HibernateUtil {

    private final SessionFactory sessionFactory = getConnection();
    
    public SessionFactory getConnection() {
        Configuration con = new Configuration().configure();
        StandardServiceRegistryBuilder build = new StandardServiceRegistryBuilder()
                .applySettings(con.getProperties());
        return con.buildSessionFactory(build.build());
    }
}
