package mixey.agent.repository.jpa;

import mixey.agent.model.Product;
import mixey.agent.repository.ProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaProductRepository implements ProductRepository{
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Product save(Product product) {
        if(product.isNew()) {
            em.persist(product);
            return product;
        } else {
            return em.merge(product);
        }
    }

    @Override
    @Transactional
    public boolean delete(Integer id) {
        return em.createQuery("DELETE FROM Product p WHERE p.id=:id")
                .setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public Product get(Integer id) {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.id=:id", Product.class);
        return query.setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Product> getAll() {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
        return query.getResultList();
    }
}
