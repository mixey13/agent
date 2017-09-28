package mixey.agent.repository.jpa;

import mixey.agent.model.Price;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaPriceRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Price save(Price price) {
        if(price.isNew()) {
            em.persist(price);
            return price;
        } else {
            return em.merge(price);
        }
    }

    @Transactional
    public boolean delete(Integer id) {
        return em.createQuery("DELETE FROM Price pr WHERE pr.id=:id")
                .setParameter("id", id).executeUpdate() != 0;
    }

    public Price get(Integer id) {
        TypedQuery<Price> query = em.createQuery("SELECT DISTINCT pr FROM Price pr LEFT JOIN FETCH pr.priceProducts WHERE pr.id=:id", Price.class);
        return query.setParameter("id", id).getSingleResult();
    }

    public Price get(Integer pc, LocalDate date, Integer org) {
        TypedQuery<Price> query = em.createQuery("SELECT DISTINCT pr FROM Price pr LEFT JOIN FETCH pr.priceProducts LEFT JOIN FETCH pr.priceCategory WHERE pr.priceCategory.id=:pc AND pr.organization.id=:org AND pr.date<=:date ORDER BY pr.date DESC", Price.class);
        return query.setParameter("pc", pc).setParameter("date", date).setParameter("org", org).setMaxResults(1).getSingleResult();
    }

    public List<Price> getAll() {
        TypedQuery<Price> query = em.createQuery("SELECT pr FROM Price pr", Price.class);
        return query.getResultList();
    }
}
