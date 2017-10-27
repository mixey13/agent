package mixey.agent.service;

import mixey.agent.AuthorizedUser;
import mixey.agent.model.Product;
import mixey.agent.repository.jpa.JpaProductRepository;
import mixey.agent.to.ProductTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService{
    @Autowired
    private JpaProductRepository productRepository;

    public Product save(ProductTo productTo) {
        Product product = new Product(productTo.getId(), productTo.getTitle(), productTo.getDescription());
        product.setOrganization(AuthorizedUser.getOrganization());
        return productRepository.save(product);
    }

    public Product update(Product product) {
        return null;
    }

    public boolean delete(Integer id) {
        return productRepository.delete(id);
    }

    public ProductTo get(Integer id) {
        return ProductTo.asTo(productRepository.get(id));
    }

    public List<ProductTo> getAll() {
        return ProductTo.listAsTo(productRepository.getAllByOrganization(AuthorizedUser.getOrganization()));
    }
}
