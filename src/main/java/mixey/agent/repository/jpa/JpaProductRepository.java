package mixey.agent.repository.jpa;

import mixey.agent.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaProductRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Product save(Product product) {
        if(product.isNew()) {
            em.persist(product);
            return product;
        } else {
            return em.merge(product);
        }
    }

    @Transactional
    public boolean delete(Integer id) {
        return em.createQuery("DELETE FROM Product p WHERE p.id=:id")
                .setParameter("id", id).executeUpdate() != 0;
    }

    public Product get(Integer id) {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.id=:id", Product.class);
        return query.setParameter("id", id).getSingleResult();
    }

    public List<Product> getAll() {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
        return query.getResultList();
    }

    public Product getRef(Integer id) {
        return em.getReference(Product.class, id);
    }
}
