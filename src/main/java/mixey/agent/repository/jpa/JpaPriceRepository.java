package mixey.agent.repository.jpa;

import mixey.agent.model.Price;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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

    public List<Price> getAll() {
        TypedQuery<Price> query = em.createQuery("SELECT pr FROM Price pr", Price.class);
        List<Price> list = query.getResultList();
        return list;
    }
}
