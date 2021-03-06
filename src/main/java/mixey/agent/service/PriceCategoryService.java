package mixey.agent.service;

import mixey.agent.AuthorizedUser;
import mixey.agent.model.PriceCategory;
import mixey.agent.repository.jpa.JpaPriceCategoryRepository;
import mixey.agent.to.PriceCategoryTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCategoryService {
    @Autowired
    private JpaPriceCategoryRepository repository;

    public PriceCategory save(PriceCategoryTo priceCategoryTo) {
        PriceCategory priceCategory = new PriceCategory(priceCategoryTo.getId(), priceCategoryTo.getName(), priceCategoryTo.getDescription());
        priceCategory.setOrganization(AuthorizedUser.getOrganization());
        return repository.save(priceCategory);
    }

    public PriceCategory update(PriceCategory priceCategory) {
        return null;
    }

    public boolean delete(Integer id) {
        return repository.delete(id);
    }

    public PriceCategoryTo get(Integer id) {
        return PriceCategoryTo.asTo(repository.get(id));
    }

    public List<PriceCategoryTo> getAll() {
        return PriceCategoryTo.listAsTo(repository.getAllByOrganization(AuthorizedUser.getOrganization()));
    }
}
