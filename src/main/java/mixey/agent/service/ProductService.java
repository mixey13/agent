package mixey.agent.service;

import mixey.agent.model.Product;
import mixey.agent.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService{
    @Autowired
    private ProductRepository repository;

    public Product save(Product product) {
        return repository.save(product);
    }

    public Product update(Product product) {
        return repository.save(product);
    }

    public boolean delete(Integer id) {
        return repository.delete(id);
    }

    public Product get(Integer id) {
        return repository.get(id);
    }

    public List<Product> getAll() {
        return repository.getAll();
    }
}
