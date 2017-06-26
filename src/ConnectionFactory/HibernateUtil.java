package ConnectionFactory;

import javax.imageio.spi.ServiceRegistry;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author tiago
 */
public class HibernateUtil {

    SessionFactory sessioFactory = getConnection();
    
    public SessionFactory getConnection() {
        Configuration con = new Configuration().configure();
        StandardServiceRegistryBuilder build = new StandardServiceRegistryBuilder()
                .applySettings(con.getProperties());
        return con.buildSessionFactory(build.build());
    }
}
