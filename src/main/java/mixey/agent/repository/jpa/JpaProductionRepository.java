package mixey.agent.repository.jpa;

import mixey.agent.model.Production;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaProductionRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Production save(Production production) {
        if(production.isNew()) {
            em.persist(production);
            return production;
        } else {
            return em.merge(production);
        }
    }

    @Transactional
    public boolean delete(Integer id) {
        return em.createQuery("DELETE FROM Production prod WHERE prod.id=:id")
                .setParameter("id", id).executeUpdate() != 0;
    }

    public Production get(Integer id) {
        TypedQuery<Production> query = em.createQuery("SELECT DISTINCT prod FROM Production prod LEFT JOIN FETCH prod.productionProducts WHERE prod.id=:id", Production.class);
        return query.setParameter("id", id).getSingleResult();
    }

    public List<Production> getAll() {
        TypedQuery<Production> query = em.createQuery("SELECT prod FROM Production prod", Production.class);
        List<Production> list = query.getResultList();
        return list;
    }
}
