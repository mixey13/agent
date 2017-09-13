package mixey.agent.repository.jpa;

import mixey.agent.model.Balance;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaBalanceRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Balance> getBalance() {
        TypedQuery<Balance> query = em.createQuery("SELECT b FROM Balance b", Balance.class);
        return query.getResultList();
    }
}
