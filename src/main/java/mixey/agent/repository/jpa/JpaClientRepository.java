package mixey.agent.repository.jpa;

import mixey.agent.model.Client;
import mixey.agent.model.Organization;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaClientRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Client save(Client client) {
        if(client.isNew()) {
            em.persist(client);
            return client;
        } else {
            return em.merge(client);
        }
    }

    @Transactional
    public boolean delete(Integer id) {
        return em.createQuery("DELETE FROM Client c WHERE c.id=:id")
                .setParameter("id", id).executeUpdate() != 0;
    }

    public Client get(Integer id) {
        TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c WHERE c.id=:id", Client.class);
        return query.setParameter("id", id).getSingleResult();
    }

    public List<Client> getAll() {
        TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c", Client.class);
        return query.getResultList();
    }

    public List<Client> getAllByOrganization(Organization org) {
        TypedQuery<Client> query = em.createQuery("SELECT cl FROM Client cl JOIN Contract co ON cl=co.client WHERE co.organization=:org", Client.class);
        return query.setParameter("org", org).getResultList();
    }

    public Client getRef(Integer id) {
        return em.getReference(Client.class, id);
    }
}
