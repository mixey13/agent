package mixey.agent.repository;

import mixey.agent.model.Product;

import java.util.Collection;

public interface ProductRepository {
    Product save(Product product);
    boolean delete(Integer id);
    Product get(Integer id);
    Collection<Product> getAll();
}
