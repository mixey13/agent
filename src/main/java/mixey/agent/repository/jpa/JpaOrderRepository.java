package mixey.agent.repository.jpa;

import mixey.agent.model.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaOrderRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Order save() {
        return null;
    }

    @Transactional
    public boolean delete(Integer id) {
        return em.createQuery("DELETE FROM Order o WHERE o.id=:id")
                .setParameter("id", id).executeUpdate() != 0;
    }

    public Order get(Integer id) {
        TypedQuery<Order> query = em.createQuery("SELECT DISTINCT o FROM Order o LEFT JOIN FETCH o.orderProducts WHERE o.id=:id", Order.class);
        return query.setParameter("id", id).getSingleResult();
    }

    public List<Order> getAll() {
        TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o", Order.class);
        return query.getResultList();
    }
}
