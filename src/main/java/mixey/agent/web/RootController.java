package mixey.agent.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RootController {
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String productList() {
        return "productList";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String userList() {
        return "userList";
    }

    @RequestMapping(value = "/pc", method = RequestMethod.GET)
    public String priceCategoryList() {
        return "pcList";
    }

    @RequestMapping(value = "/prices", method = RequestMethod.GET)
    public String priceList() {
        return "priceList";
    }

    @RequestMapping(value = "/organizations", method = RequestMethod.GET)
    public String organizationList() {
        return "orgList";
    }

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public String clientList() {
        return "clientList";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String orderList() {
        return "orderList";
    }

    @RequestMapping(value = "/productions", method = RequestMethod.GET)
    public String productionList() {
        return "productionList";
    }
}
