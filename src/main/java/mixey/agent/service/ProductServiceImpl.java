package mixey.agent.service;

import mixey.agent.model.Product;
import mixey.agent.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public boolean delete(Integer id) {
        return repository.delete(id);
    }

    @Override
    public Product get(Integer id) {
        return repository.get(id);
    }

    @Override
    public List<Product> getAll() {
        return repository.getAll();
    }
}
