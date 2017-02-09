package mixey.agent.repository.mock;

import mixey.agent.model.Product;
import mixey.agent.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MockProductRepository implements ProductRepository {
    private Map<Integer, Product> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        save(new Product("Колбаса123", "Описание колбасы"));
        save(new Product("Ветчина", "Описание ветчины"));
        save(new Product("Сосиски", "Описание Сосисок"));
    }

    @Override
    public Product save(Product product) {
        if(product.isNew()) {
            product.setId(counter.incrementAndGet());
        }
        return repository.put(product.getId(), product);
    }

    @Override
    public boolean delete(Integer id) {
        return repository.remove(id) != null;
    }

    @Override
    public Product get(Integer id) {
        return repository.get(id);
    }

    @Override
    public List<Product> getAll() {
        return null;
    }
}
