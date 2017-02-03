package mixey.agent.repository;

import mixey.agent.model.Product;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryProductRepository {
    private Map<Integer, Product> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        save(new Product("Колбаса", "Описание колбасы"));
        save(new Product("Ветчина", "Описание ветчины"));
        save(new Product("Сосиски", "Описание Сосисок"));
    }

    public Product save(Product product) {
        if(product.isNew()) {
            product.setId(counter.incrementAndGet());
        }
        return repository.put(product.getId(), product);
    }

    public void delete(Integer id) {
        repository.remove(id);
    }

    public Product get(Integer id) {
        return repository.get(id);
    }

    public Collection<Product> getAll() {
        return repository.values();
    }
}
