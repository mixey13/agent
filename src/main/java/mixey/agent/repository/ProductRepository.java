package mixey.agent.repository;

import mixey.agent.model.Product;

import java.util.List;

public interface ProductRepository {
    Product save(Product product);
    boolean delete(Integer id);
    Product get(Integer id);
    List<Product> getAll();
}
