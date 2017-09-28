package mixey.agent.web;

import mixey.agent.model.Product;
import mixey.agent.service.ProductService;
import mixey.agent.to.ProductTo;
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
    public ProductTo get(@PathVariable("id") Integer id) {
        return service.get(id);
    }


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductTo> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/org/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductTo> getAllByOrganization(@PathVariable("id") Integer id) {
        return service.getAllByOrganization(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void updateOrCreate(@RequestBody ProductTo productTo) {
        service.save(productTo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") int id) {
        return service.delete(id);
    }
}
