package launch;

import dto.models.Giraffe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("giraffes")
@Produces(MediaType.APPLICATION_JSON)
public class GiraffeService {
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @GET
    public List<Giraffe> getGiraffes(){
        Session session = sessionFactory.openSession();
        CriteriaQuery<Giraffe> query = session.getCriteriaBuilder().createQuery(Giraffe.class);
        Root<Giraffe> from = query.from(Giraffe.class);
        query.select(from);
        List<Giraffe> resultList = session.createQuery(query).getResultList();
        return resultList;
    }

    @POST
    public Giraffe save(Giraffe giraffe){
        Session session = sessionFactory.openSession();
        session.save(giraffe);
        session.close();
        return giraffe;
    }
}
