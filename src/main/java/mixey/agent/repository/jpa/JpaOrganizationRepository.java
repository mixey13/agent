package mixey.agent.repository.jpa;

import mixey.agent.model.Organization;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaOrganizationRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Organization save(Organization organization) {
        if(organization.isNew()) {
            em.persist(organization);
            return organization;
        } else {
            return em.merge(organization);
        }
    }

    @Transactional
    public boolean delete(Integer id) {
        return em.createQuery("DELETE FROM Organization o WHERE o.id=:id")
                .setParameter("id", id).executeUpdate() != 0;
    }

    public Organization get(Integer id) {
        TypedQuery<Organization> query = em.createQuery("SELECT o FROM Organization o WHERE o.id=:id", Organization.class);
        return query.setParameter("id", id).getSingleResult();
    }

    public List<Organization> getAll() {
        TypedQuery<Organization> query = em.createQuery("SELECT o FROM Organization o", Organization.class);
        return query.getResultList();
    }
}
