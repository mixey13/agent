package mixey.agent.service;

import mixey.agent.model.PriceCategory;
import mixey.agent.repository.jpa.JpaPriceCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCategoryService {
    @Autowired
    private JpaPriceCategoryRepository repository;

    public PriceCategory save(PriceCategory priceCategory) {
        return repository.save(priceCategory);
    }

    public PriceCategory update(PriceCategory priceCategory) {
        return repository.save(priceCategory);
    }

    public boolean delete(Integer id) {
        return repository.delete(id);
    }

    public PriceCategory get(Integer id) {
        return repository.get(id);
    }

    public List<PriceCategory> getAll() {
        return repository.getAll();
    }
}
