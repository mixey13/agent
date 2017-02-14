package mixey.agent.web;

import mixey.agent.model.Product;
import mixey.agent.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ajax/products")
public class ProductAjaxController {
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

    @RequestMapping(method = RequestMethod.POST)
    public void updateOrCreate(@RequestParam("id") int id,
                               @RequestParam("title") String title,
                               @RequestParam("description") String description
                               ) {
        Product product = new Product(id, title, description);
        if (id == 0) {
            service.save(product);
        } else {
            service.update(product);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@RequestParam("id") int id) {
        return service.delete(id);
    }
}
