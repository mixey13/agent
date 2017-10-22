package mixey.agent.repository.jpa;

import mixey.agent.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaUserRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public User save(User user) {
        if(user.isNew()) {
            em.persist(user);
            return user;
        } else {
            return em.merge(user);
        }
    }

    @Transactional
    public boolean delete(Integer id) {
        return em.createQuery("DELETE FROM User u WHERE u.id=:id")
                .setParameter("id", id).executeUpdate() != 0;
    }

    public User get(Integer id) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.id=:id", User.class);
        return query.setParameter("id", id).getSingleResult();
    }

    public User getByName(String name) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.name=:name", User.class);
        return query.setParameter("name", name).getSingleResult();
    }

    public List<User> getAll() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }
}
