package mixey.agent.repository.jpa;

import mixey.agent.model.Admin;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaAdminRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Admin save(Admin admin) {
        if(admin.isNew()) {
            em.persist(admin);
            return admin;
        } else {
            return em.merge(admin);
        }
    }

    @Transactional
    public boolean delete(Integer id) {
        return em.createQuery("DELETE FROM Admin a WHERE a.id=:id")
                .setParameter("id", id).executeUpdate() != 0;
    }

    public Admin get(Integer id) {
        TypedQuery<Admin> query = em.createQuery("SELECT a FROM Admin a WHERE a.id=:id", Admin.class);
        return query.setParameter("id", id).getSingleResult();
    }

    public List<Admin> getAll() {
        TypedQuery<Admin> query = em.createQuery("SELECT a FROM Admin a", Admin.class);
        return query.getResultList();
    }
}
