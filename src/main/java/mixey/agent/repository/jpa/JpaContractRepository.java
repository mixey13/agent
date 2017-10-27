package mixey.agent.repository.jpa;

import mixey.agent.model.Contract;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaContractRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Contract save(Contract contract) {
        if(contract.isNew()) {
            em.persist(contract);
            return contract;
        } else {
            return em.merge(contract);
        }
    }

    @Transactional
    public boolean delete(Integer id) {
        return em.createQuery("DELETE FROM Contract c WHERE c.id=:id")
                .setParameter("id", id).executeUpdate() != 0;
    }

    public Contract get(Integer id) {
        TypedQuery<Contract> query = em.createQuery("SELECT c FROM Contract c WHERE c.id=:id", Contract.class);
        return query.setParameter("id", id).getSingleResult();
    }

    public List<Contract> getAll() {
        TypedQuery<Contract> query = em.createQuery("SELECT c FROM Client c", Contract.class);
        return query.getResultList();
    }

    public List<Contract> getAllByOrganization(Integer org) {
        TypedQuery<Contract> query = em.createQuery("SELECT c FROM Contract c LEFT JOIN FETCH c.organization WHERE c.organization.id=:org", Contract.class);
        return query.setParameter("org", org).getResultList();
    }
}
