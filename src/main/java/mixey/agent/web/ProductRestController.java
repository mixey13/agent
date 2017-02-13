package mixey.agent.web;

import mixey.agent.model.Product;

import mixey.agent.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
    @Autowired
    private ProductService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Product get(@PathVariable("id") Integer id) {
        return service.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAll() {
        return service.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Product create(@RequestBody Product product) {
        product.setId(null);
        return service.save(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product update(@RequestBody Product product, @PathVariable("id") Integer id) {
        product.setId(id);
        return service.update(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(Integer id) {
        return service.delete(id);
    }
}
