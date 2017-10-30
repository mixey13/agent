package mixey.agent.repository.jpa;

import mixey.agent.model.Balance;
import mixey.agent.model.Organization;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaBalanceRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Balance> getBalance(Organization org) {
        TypedQuery<Balance> query = em.createQuery("SELECT new Balance(b.product, SUM (b.amount)) FROM Balance b WHERE b.organization=:org GROUP BY b.product", Balance.class);
        return query.setParameter("org", org).getResultList();
    }

    public List<Balance> getBalance(LocalDate date, Organization org) {
        TypedQuery<Balance> query = em.createQuery("SELECT new Balance(b.product, SUM (b.amount)) FROM Balance b WHERE b.organization=:org AND b.date<=:date GROUP BY b.product", Balance.class);
        return query.setParameter("org", org).setParameter("date", date).getResultList();
    }
}
