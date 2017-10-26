package mixey.agent.service;

import mixey.agent.AuthorizedUser;
import mixey.agent.model.Price;
import mixey.agent.model.PriceProduct;
import mixey.agent.model.Product;
import mixey.agent.repository.jpa.*;
import mixey.agent.to.PriceProductTo;
import mixey.agent.to.PriceTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PriceService {
    @Autowired
    private JpaPriceRepository priceRepository;
    @Autowired
    private JpaPriceCategoryRepository priceCategoryRepository;
    @Autowired
    private JpaClientRepository clientRepository;
    @Autowired
    private JpaProductRepository productRepository;

    public Price save(PriceTo priceTo) {
        Price price = new Price(priceTo.getId(), LocalDate.parse(priceTo.getDate()));
        price.setOrganization(AuthorizedUser.getOrganization());
        price.setPriceCategory(priceCategoryRepository.getRef(priceTo.getPriceCategory()));
        Set<PriceProduct> priceProducts = new HashSet<>();
        for(PriceProductTo priceProductTo : priceTo.getPriceProductTos()) {
            Product product = productRepository.getRef(priceProductTo.getProduct());
            PriceProduct priceProduct = new PriceProduct(product, priceProductTo.getValue());
            priceProduct.setPrice(price);
            priceProducts.add(priceProduct);
        }
        price.setPriceProducts(priceProducts);
        return priceRepository.save(price);
    }

    public Price update(PriceTo priceTo) {
        return null;
    }

    public boolean delete(Integer id) {
        return priceRepository.delete(id);
    }

    public PriceTo get(Integer id) {
        return PriceTo.asToFull(priceRepository.get(id));
    }

//    public PriceTo get(Integer cli, String date) {
//        Integer pc = clientRepository.get(cli).getPriceCategory().getId();
//        return PriceTo.asToFull(priceRepository.get(pc, LocalDate.parse(date), org));
//    }

    public List<PriceTo> getAll() {
        return PriceTo.listAsTo(priceRepository.getAllByOrganization(AuthorizedUser.getOrganization().getId()));
    }
}
