package mixey.agent.service;

import mixey.agent.AuthorizedUser;
import mixey.agent.model.Product;
import mixey.agent.model.Production;
import mixey.agent.model.ProductionProduct;
import mixey.agent.repository.jpa.JpaProductRepository;
import mixey.agent.repository.jpa.JpaProductionRepository;
import mixey.agent.to.ProductionProductTo;
import mixey.agent.to.ProductionTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductionService {
    @Autowired
    private JpaProductionRepository productionRepository;
    @Autowired
    private JpaProductRepository productRepository;

    public Production save(ProductionTo productionTo) {
        Production production = new Production(productionTo.getId(), LocalDate.parse(productionTo.getDate()), LocalTime.parse(productionTo.getTime()));
        production.setOrganization(AuthorizedUser.getOrganization());
        Set<ProductionProduct> productionProducts = new HashSet<>();
        for(ProductionProductTo productionProductTo : productionTo.getProductionProductTos()) {
            Product product = productRepository.getRef(productionProductTo.getProduct());
            ProductionProduct productionProduct = new ProductionProduct(product, productionProductTo.getAmount());
            productionProduct.setProduction(production);
            productionProducts.add(productionProduct);
        }
        production.setProductionProducts(productionProducts);
        return productionRepository.save(production);
    }

    public boolean delete(Integer id) {
        return productionRepository.delete(id);
    }

    public ProductionTo get(Integer id) {
        return ProductionTo.asToFull(productionRepository.get(id));
    }

    public List<ProductionTo> getAll() {
        return ProductionTo.listAsTo(productionRepository.getAllByOrganization(AuthorizedUser.getOrganization().getId()));
    }
}
