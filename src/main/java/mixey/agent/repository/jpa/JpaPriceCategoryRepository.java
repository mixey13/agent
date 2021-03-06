package mixey.agent.repository.jpa;

import mixey.agent.model.Organization;
import mixey.agent.model.PriceCategory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaPriceCategoryRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public PriceCategory save(PriceCategory priceCategory) {
        if(priceCategory.isNew()) {
            em.persist(priceCategory);
            return priceCategory;
        } else {
            return em.merge(priceCategory);
        }
    }

    @Transactional
    public boolean delete(Integer id) {
        return em.createQuery("DELETE FROM PriceCategory pc WHERE pc.id=:id")
                .setParameter("id", id).executeUpdate() != 0;
    }

    public PriceCategory get(Integer id) {
        TypedQuery<PriceCategory> query = em.createQuery("SELECT pc FROM PriceCategory pc WHERE pc.id=:id", PriceCategory.class);
        return query.setParameter("id", id).getSingleResult();
    }

    public List<PriceCategory> getAll() {
        TypedQuery<PriceCategory> query = em.createQuery("SELECT pc FROM PriceCategory pc", PriceCategory.class);
        return query.getResultList();
    }

    public List<PriceCategory> getAllByOrganization(Organization org) {
        TypedQuery<PriceCategory> query = em.createQuery("SELECT pc FROM PriceCategory pc LEFT JOIN FETCH pc.organization WHERE pc.organization=:org", PriceCategory.class);
        return query.setParameter("org", org).getResultList();
    }

    public PriceCategory getRef(Integer id) {
        return em.getReference(PriceCategory.class, id);
    }
}
