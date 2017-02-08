package mixey.agent.service;

import mixey.agent.model.Product;
import java.util.List;

public interface ProductService {
    Product save(Product product);
    boolean delete(Integer id);
    Product get(Integer id);
    List<Product> getAll();
}
