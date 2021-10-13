package launch;

import dto.models.Giraffe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;

import javax.persistence.Entity;
import java.net.MalformedURLException;
import java.util.Set;

public class DBTest {
    public static void main(String[] args) throws MalformedURLException {
        Configuration configuration = new Configuration();

        Reflections reflections = new Reflections("dto.models");
        Set<Class<?>> entities = reflections.getTypesAnnotatedWith(Entity.class);
        entities.forEach((Class<?> c) -> {
            System.out.println("Found: " + c);
            configuration.addAnnotatedClass(c);
        });
        configuration.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty("hibernate.connection.username","postgres");
        configuration.setProperty("hibernate.connection.password","4D7pTNepxAP5542q");
        configuration.setProperty("hibernate.connection.url","jdbc:postgresql://localhost:5432/hibernatedb");
        configuration.setProperty("hibernate.hbm2ddl.auto","update");

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Giraffe DBUser = new Giraffe();
        DBUser.setId(12);
        DBUser.setName("First name");
        session.save(DBUser);
        transaction.commit();


    }
}
