package mixey.agent.web;

import mixey.agent.model.Product;


import mixey.agent.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductRestController {
    @Autowired
    private ProductService service;

    public List<Product> getAll() {
        return service.getAll();
    }
}
