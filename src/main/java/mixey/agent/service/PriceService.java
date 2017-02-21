package mixey.agent.service;

import mixey.agent.model.Price;
import mixey.agent.repository.jpa.JpaPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {
    @Autowired
    private JpaPriceRepository repository;

    public Price save(Price price) {
        return repository.save(price);
    }

    public Price update(Price price) {
        return repository.save(price);
    }

    public boolean delete(Integer id) {
        return repository.delete(id);
    }

    public Price get(Integer id) {
        return repository.get(id);
    }

    public List<Price> getAll() {
        return repository.getAll();
    }
}