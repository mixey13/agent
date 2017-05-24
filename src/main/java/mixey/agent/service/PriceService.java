package mixey.agent.service;

import mixey.agent.model.Price;
import mixey.agent.model.PriceProduct;
import mixey.agent.repository.jpa.JpaPriceRepository;
import mixey.agent.to.PriceTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class PriceService {
    @Autowired
    private JpaPriceRepository repository;

    public Price save(PriceTo priceTo) {
        Price price = new Price(priceTo.getId(), priceTo.getNumber(), LocalDate.parse(priceTo.getDate()));
        return repository.save(price, priceTo.getPriceCategory(), priceTo.getProductValue());
    }

    public Price update(PriceTo priceTo) {
        Price price = new Price(priceTo.getId(), priceTo.getNumber(), LocalDate.parse(priceTo.getDate()));
        return repository.save(price, priceTo.getPriceCategory(), priceTo.getProductValue());
    }

    public boolean delete(Integer id) {
        return repository.delete(id);
    }

    public PriceTo get(Integer id) {
        Price price = repository.get(id);
        PriceTo priceTo = PriceTo.asTo(price);
        Map<Integer, Integer> map = new HashMap<>();
        for (PriceProduct p : price.getPriceProducts()) {
            map.put(p.getProduct().getId(), p.getValue());
        }
        priceTo.setProductValue(map);
        System.out.println(priceTo);
        return priceTo;
    }

    public List<PriceTo> getAll() {
        return PriceTo.listAsTo(repository.getAll());
    }
}
