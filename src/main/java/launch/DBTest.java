package launch;

import dto.models.Giraffe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DBTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Giraffe DBUser = new Giraffe();
        DBUser.setId(12);
        DBUser.setName("First name");
        session.save(DBUser);
        transaction.commit();


    }
}
