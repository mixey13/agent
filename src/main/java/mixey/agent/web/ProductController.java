package mixey.agent.web;

import mixey.agent.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
    @Autowired
    private ProductService service;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String productList(Model model) {
        model.addAttribute("productList", service.getAll());
        return "productList";
    }
}
