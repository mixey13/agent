package mixey.agent.repository.jpa;

import mixey.agent.model.BaseUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
@Transactional(readOnly = true)
public class JpaSecurityRepository {
    @PersistenceContext
    private EntityManager em;

    public BaseUser getByName(String name) {
        TypedQuery<BaseUser> query = em.createQuery("SELECT bu FROM BaseUser bu WHERE bu.name=:name", BaseUser.class);
        return query.setParameter("name", name).getSingleResult();
    }
}
